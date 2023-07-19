package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.flow.Executor;
import com.changhong.sei.core.dto.flow.FlowInvokeParams;
import com.changhong.sei.core.dto.serach.Search;
import com.domlin.strategy.dto.StrategyUserDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 人员信息(StrategyUser)API
 *
 * @author wake
 * @since 2023-05-09 15:13:34
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyUserApi.PATH)
public interface StrategyUserApi extends BaseEntityApi<StrategyUserDto>,FindByPageApi<StrategyUserDto> {
    String PATH = "strategyUser";

    //写一个方法，更新strategyUser
    @PostMapping(path = "update")
    @ApiOperation("更新strategyUser")
    ResultData<StrategyUserDto> update(@RequestBody StrategyUserDto strategyUser);

    //写一个导出方法，导出全部strategyUser
    @PostMapping(path = "export")
    @ApiOperation(value = "导出全部strategyUser", notes = "导出全部strategyUser")
    ResultData<List<StrategyUserDto>> export(@RequestBody Search search);

    //写一个方法导入strategyUser
    @PostMapping(path = "uploadStrategyUser")
    @ApiOperation(value = "导入strategyUser", notes = "导入strategyUser")
    ResultData<String> uploadStrategyUser(@RequestBody List<StrategyUserDto> list) throws Exception;


    /**
     * 流程审批-查询单位负责人
     * @param invokeParams 查询条件
     * @return 业务实体
     */
    @PostMapping(path = "findUnitOfficer",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取审批单据单位负责人", notes = "获取审批单据部门负责人")
    ResultData<List<Executor>> findUnitOfficer(@RequestBody FlowInvokeParams invokeParams);

    /**
     * 流程审批-查询经营策略组人
     * @param invokeParams 查询条件
     * @return 业务实体
     */
    @PostMapping(path = "findManagements",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取审批单据单位负责人", notes = "获取审批单据部门负责人")
    ResultData<List<Executor>> findManagements(@RequestBody FlowInvokeParams invokeParams);

    /**
     * 流程审批-查询项目相关方
     */
    @PostMapping(path = "findRelates",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取审批单据项目相关方", notes = "获取审批单据项目相关方")
    ResultData<List<Executor>> findRelates(@RequestBody FlowInvokeParams invokeParams);

}
