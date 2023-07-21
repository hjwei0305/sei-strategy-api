package com.domlin.strategy.service;

import com.changhong.sei.basic.api.SysUserApi;
import com.changhong.sei.basic.dto.SysUserDto;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.domlin.strategy.dao.StrategyContactRelationDao;
import com.domlin.strategy.dao.StrategyProjectOfficerRelationDao;
import com.domlin.strategy.dao.StrategyRelatedRelationDao;
import com.domlin.strategy.dao.StrategyUserDao;
import com.domlin.strategy.dto.StrategyProjectDto;
import com.domlin.strategy.dto.StrategyUserDto;
import com.domlin.strategy.entity.StrategyContactRelation;
import com.domlin.strategy.entity.StrategyProjectOfficerRelation;
import com.domlin.strategy.entity.StrategyRelatedRelation;
import com.domlin.strategy.entity.StrategyUser;
import io.netty.util.internal.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 人员信息(StrategyUser)业务逻辑实现类
 *
 * @author wake
 * @since 2023-05-09 15:13:33
 */
@Service
public class StrategyUserService extends BaseEntityService<StrategyUser> {
    @Autowired
    private StrategyUserDao dao;

    @Autowired
    private StrategyContactRelationDao contactRelationDao;

    @Autowired
    private StrategyProjectOfficerRelationDao officerRelationDao;

    @Autowired
    private StrategyRelatedRelationDao relatedRelationDao;

    @Autowired
    private SysUserApi sysUserApi;

    @Override
    protected BaseEntityDao<StrategyUser> getDao() {
        return dao;
    }

    public StrategyUser update(StrategyUser strategyUser) {
        return dao.save(strategyUser);
    }

    /**
     * 保存项目负责人人员信息
     * @param strategyProject
     * @return
     */
    public void saveProjectOfficers(StrategyProjectDto strategyProject){
        List<StrategyUserDto> officers = strategyProject.getOfficers();
        deleteOfficerByProjectId(strategyProject.getId());
        for (StrategyUserDto officer : officers) {
            String userCode = officer.getUserCode();
            List<StrategyUser> users = findByUserCode(userCode);
            if (CollectionUtils.isEmpty(users)){
                ResultData<SysUserDto> byEmployeeCode = sysUserApi.findByEmployeeCode(userCode);
                StrategyUser strategyUser = new StrategyUser();
                strategyUser.setUserCode(byEmployeeCode.getData().getEmployeeCode());
                strategyUser.setUserName(byEmployeeCode.getData().getEmployeeName());
                strategyUser.setDepartment(byEmployeeCode.getData().getOrgname());
                strategyUser.setuserState(byEmployeeCode.getData().getLjdate()==null?"在职":"离职");
                strategyUser.setPosition(byEmployeeCode.getData().getSpName());
                strategyUser.setUserId(officer. getId());
                OperateResultWithData<StrategyUser> save = save(strategyUser);
                StrategyUser saveData = save.getData();
                addOfficerelation(strategyProject.getId(), saveData.getId());
            }else {
                addOfficerelation(strategyProject.getId(), users.get(0).getId());
            }
        }
    }

    /**
     * 保存项目相关方人员信息
     * @param strategyProject
     */
    public void saveProjectRelates(StrategyProjectDto strategyProject){
        List<StrategyUserDto> relates = strategyProject.getRelates();
        deleteRelatedByProjectId(strategyProject.getId());
        for (StrategyUserDto relate : relates) {
            String userCode = relate.getUserCode();
            if(StringUtil.isNullOrEmpty(userCode)){
                continue;
            }
            List<StrategyUser> byUserCodes = findByUserCode(userCode);
            if (CollectionUtils.isEmpty(byUserCodes)){
                ResultData<SysUserDto> byEmployeeCode = sysUserApi.findByEmployeeCode(userCode);
                StrategyUser strategyUser = new StrategyUser();
                strategyUser.setUserCode(byEmployeeCode.getData().getEmployeeCode());
                strategyUser.setUserName(byEmployeeCode.getData().getEmployeeName());
                strategyUser.setDepartment(byEmployeeCode.getData().getOrgname());
                strategyUser.setuserState(byEmployeeCode.getData().getLjdate()==null?"在职":"离职");
                strategyUser.setPosition(byEmployeeCode.getData().getSpName());
                strategyUser.setUserId(relate.getId());
                OperateResultWithData<StrategyUser> save = save(strategyUser);
                StrategyUser saveData = save.getData();
                addRelateRelation(strategyProject.getId(), saveData.getId());
            }else {
                addRelateRelation(strategyProject.getId(), byUserCodes.get(0).getId());
            }
        }
    }

    /**
     * 保存人员信息
     * @param newRow
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public String uploadStrategyUser(List<StrategyUser> newRow) {
        if (newRow != null && newRow.size() > 0) {
            save(newRow);
        } else {
            throw new RuntimeException("导入数据不能为空");
        }
        return "导入成功";
    }

    /**
     * 根据模块编码查询联系人
     * @param moduleCode
     * @return
     */
    public List<StrategyUser> findContactByModuleCode(String moduleCode) {
        return dao.findContactByModuleCode(moduleCode);
    }

    /**
     * 根据项目id  查询  模块单位负责人
     * @param moduleCode
     * @return
     */
    public List<StrategyUser> findUnitOfficer(String moduleCode) {
        return dao.findUnitOfficer(moduleCode);
    }

    /**
     * 根据用户编码查询用户信息
     * @param userCode
     * @return
     */
    public List<StrategyUser> findByUserCode(String userCode) {
        return dao.findByUserCode(userCode);
    }

    /**
     *  根据项目id和用户id添加联系人关系
     * @param projectId
     * @param userId
     */
    public void addContactRelation(String projectId, String userId) {
        Integer count = contactRelationDao.countByProjectAndUserId(projectId, userId);
        if (count > 0) {
            return;
        }
        StrategyContactRelation contactRelation = new StrategyContactRelation();
        contactRelation.setProjectId(projectId);
        contactRelation.setUserId(userId);
        contactRelationDao.save(contactRelation);
    }

    /**
     * 根据项目id和用户id添加项目负责人关系
     * @param projectId
     * @param userId
     */
    public void addOfficerelation(String projectId, String userId) {
        Integer count = officerRelationDao.countByProjectAndUserId(projectId, userId);
        if (count > 0) {
            return;
        }
        StrategyProjectOfficerRelation contactRelation = new StrategyProjectOfficerRelation();
        contactRelation.setProjectId(projectId);
        contactRelation.setUserId(userId);
        officerRelationDao.save(contactRelation);
    }

    /**
     * 根据项目id查询项目负责人
     * @param projectId
     * @return
     */
    public List<StrategyUser> findOfficerByProjectId(String projectId) {
        return dao.findOfficerByProjectId(projectId);
    }

    /**
     * 根据项目id删除项目负责人
     */
    public void deleteOfficerByProjectId(String projectId) {
        officerRelationDao.deleteByProjectId(projectId);
    }

    /**
     * 根据项目id和用户id添加项目相关方关系
     * @param id
     * @param id1
     * @return
     */
    public void addRelateRelation(String id, String id1) {
        Integer count = relatedRelationDao.countByProjectAndUserId(id, id1);
        if (count > 0) {
            return;
        }
        StrategyRelatedRelation relatedRelation = new StrategyRelatedRelation();
        relatedRelation.setProjectId(id);
        relatedRelation.setUserId(id1);
        relatedRelationDao.save(relatedRelation);
    }

    /**
     * 根据项目id查询相关方
     * @param id
     * @return
     */
    public List<StrategyUser> findByStrategyProjectId(String id) {
        return dao.findRelatedByProjectId(id);
    }

    /**
     * 根据项目id删除相关方
     * @param id
     * @return
     */
    public void deleteRelatedByProjectId(String id) {
        relatedRelationDao.deleteByProjectId(id);
    }

    /**
     * 根据模块编码查询经营策略管理组成员
     * @param moduleCode
     * @return
     */
    public List<StrategyUser> findManagementsByModuleCode(String moduleCode) {
        return dao.findManagementsByModuleCode(moduleCode);
    }

    /**
     * 根据模块编码查询经模块负责人
     * @param moduleCode
     * @return
     */
    public List<StrategyUser> findLeader(String moduleCode) {
        return dao.findLeader(moduleCode);
    }
}
