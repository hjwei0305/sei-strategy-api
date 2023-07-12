package com.domlin.strategy.controller;

import com.changhong.sei.basic.api.SysUserApi;
import com.changhong.sei.basic.dto.SysUserDto;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.domlin.strategy.api.StrategyProjectApi;
import com.domlin.strategy.dto.StrategyProjectDto;
import com.domlin.strategy.dto.StrategyUserDto;
import com.domlin.strategy.entity.StrategyProject;
import com.domlin.strategy.entity.StrategyUser;
import com.domlin.strategy.flow.BaseFlowController;
import com.domlin.strategy.flow.BaseFlowEntityService;
import com.domlin.strategy.service.StrategyProjectPlansService;
import com.domlin.strategy.service.StrategyProjectService;
import com.domlin.strategy.service.StrategyUserService;
import io.netty.util.internal.StringUtil;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目(StrategyProject)控制类
 *
 * @author wake
 * @since 2023-05-09 15:12:50
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectApi", tags = "项目服务")
@RequestMapping(path = StrategyProjectApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectController extends BaseFlowController<StrategyProject, StrategyProjectDto> implements StrategyProjectApi {
    /**
     * 项目服务对象
     */
    @Autowired
    private StrategyProjectService service;

    @Autowired
    private StrategyUserService userService;

    @Autowired
    private SysUserApi sysUserApi;

    @Override
    public BaseFlowEntityService<StrategyProject> getService() {
        return service;
    }

    @Override
    protected String getWorkCaption(StrategyProject strategyProject) {
        return "ESS出厂单据流程" +strategyProject.getCode();
    }

    @Override
    protected String getFlowName(StrategyProject strategyProject) {
        return "ES1111出厂单据流程" +strategyProject.getCode();
    }

    @Override
    protected String getBusinessCode(StrategyProject strategyProject) {
        return null;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private StrategyProjectPlansService plansService;

    @Override
    public ResultData<PageResult<StrategyProjectDto>> findByPage(Search search) {
        PageResult<StrategyProjectDto> newPageResult = new PageResult<>();
        List<StrategyProjectDto> newRows = new ArrayList<>();
        PageResult<StrategyProject> pageResult = service.findByPage(search);
        if (CollectionUtils.isNotEmpty(pageResult.getRows())){
            pageResult.getRows().forEach(x -> newRows.add(modelMapper.map(x, StrategyProjectDto.class)));
            newPageResult.setRows(newRows);
            newPageResult.setTotal(pageResult.getTotal());
            newPageResult.setPage(pageResult.getPage());
        }
        return ResultData.success(newPageResult);
    }

    public ResultData<StrategyProjectDto> update(StrategyProjectDto strategyProject) {
        if (strategyProject != null) {
            StrategyProject entity = modelMapper.map(strategyProject, StrategyProject.class);
            //保存模块对接人关联关系
            List<StrategyUserDto> contacts = strategyProject.getContacts();
            if (contacts == null || contacts.size() == 0){
                return ResultData.fail("模块对接人不能为空");
            }
            userService.addContactRelation(strategyProject.getId(), contacts.get(0).getId());
            //保存项目负责人关联关系
            List<StrategyUserDto> officers = strategyProject.getOfficers();
            userService.deleteOfficerByProjectId(strategyProject.getId());
            for (StrategyUserDto officer : officers) {
                String userCode = officer.getUserCode();
                List<StrategyUser> users = userService.findByUserCode(userCode);
                if (CollectionUtils.isEmpty(users)){
                    ResultData<SysUserDto> byEmployeeCode = sysUserApi.findByEmployeeCode(userCode);
                    StrategyUser strategyUser = new StrategyUser();
                    strategyUser.setUserCode(byEmployeeCode.getData().getEmployeeCode());
                    strategyUser.setUserName(byEmployeeCode.getData().getEmployeeName());
                    strategyUser.setDepartment(byEmployeeCode.getData().getOrgname());
                    strategyUser.setuserState(byEmployeeCode.getData().getLjdate()==null?"在职":"离职");
                    strategyUser.setPosition(byEmployeeCode.getData().getSpName());
                    strategyUser.setUserId(byEmployeeCode.getData().getId());
                    OperateResultWithData<StrategyUser> save = userService.save(strategyUser);
                    StrategyUser saveData = save.getData();
                    userService.addOfficerelation(strategyProject.getId(), saveData.getId());
                }else {
                    userService.addOfficerelation(strategyProject.getId(), users.get(0).getId());
                }
            }
            //保存项目相关方
            List<StrategyUserDto> relates = strategyProject.getRelates();
            userService.deleteRelatedByProjectId(strategyProject.getId());
            for (StrategyUserDto relate : relates) {
                String userCode = relate.getUserCode();
                if(StringUtil.isNullOrEmpty(userCode)){
                    continue;
                }
                List<StrategyUser> byUserCodes = userService.findByUserCode(userCode);
                if (CollectionUtils.isEmpty(byUserCodes)){
                    ResultData<SysUserDto> byEmployeeCode = sysUserApi.findByEmployeeCode(userCode);
                    StrategyUser strategyUser = new StrategyUser();
                    strategyUser.setUserCode(byEmployeeCode.getData().getEmployeeCode());
                    strategyUser.setUserName(byEmployeeCode.getData().getEmployeeName());
                    strategyUser.setDepartment(byEmployeeCode.getData().getOrgname());
                    strategyUser.setuserState(byEmployeeCode.getData().getLjdate()==null?"在职":"离职");
                    strategyUser.setPosition(byEmployeeCode.getData().getSpName());
                    strategyUser.setUserId(byEmployeeCode.getData().getId());
                    OperateResultWithData<StrategyUser> save = userService.save(strategyUser);
                    StrategyUser saveData = save.getData();
                    userService.addRelateRelation(strategyProject.getId(), saveData.getId());
                }else {
                    userService.addRelateRelation(strategyProject.getId(), byUserCodes.get(0).getId());
                }
            }
            // 保存项目计划
            plansService.save(strategyProject);
            //  保存项目
            service.save(entity);
            return ResultData.success(modelMapper.map(entity, StrategyProjectDto.class));
        }
        return ResultData.fail("参数不能为空");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData<StrategyProjectDto> save(StrategyProjectDto strategyProject) {
        return update(strategyProject);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResultData<StrategyProjectDto> submitProject(StrategyProjectDto strategyProject) throws Exception {
        ResultData<StrategyProjectDto> updatedProject = ResultData.fail("提交失败");
        // 保存项目
        if (strategyProject != null) {
            updatedProject = update(strategyProject);
        }
        // 提交流程
        return updatedProject;
    }
}
