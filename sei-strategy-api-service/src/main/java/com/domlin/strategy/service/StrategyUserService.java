package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyContactRelationDao;
import com.domlin.strategy.dao.StrategyProjectOfficerRelationDao;
import com.domlin.strategy.dao.StrategyRelatedRelationDao;
import com.domlin.strategy.dao.StrategyUserDao;
import com.domlin.strategy.entity.StrategyContactRelation;
import com.domlin.strategy.entity.StrategyProjectOfficerRelation;
import com.domlin.strategy.entity.StrategyRelatedRelation;
import com.domlin.strategy.entity.StrategyUser;
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

    @Override
    protected BaseEntityDao<StrategyUser> getDao() {
        return dao;
    }

    public StrategyUser update(StrategyUser strategyUser) {
        return dao.save(strategyUser);
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

    public List<StrategyUser> findManagementsByModuleCode(String moduleCode) {
        return dao.findManagementsByModuleCode(moduleCode);
    }
}
