package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.domlin.strategy.dto.StrategyBillModuleDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 经营策略模块(StrategyBillModule)API
 *
 * @author wake
 * @since 2023-05-09 15:10:16
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyBillModuleApi.PATH)
public interface StrategyBillModuleApi extends BaseEntityApi<StrategyBillModuleDto>, FindByPageApi<StrategyBillModuleDto> {
    String PATH = "strategyBillModule";


    //写一个方法，update StrategyBillModule
    @PostMapping(path = "update",consumes = "application/json")
    @ApiOperation("更新StrategyBillModule")
    ResultData<StrategyBillModuleDto> update(@RequestBody StrategyBillModuleDto strategyBillModule);

    //写一个导出方法，导出全部StrategyBillModule
    @PostMapping(path = "export",consumes = "application/json")
    @ApiOperation(value = "导出全部StrategyBillModule", notes = "导出全部StrategyBillModule")
    ResultData<List<StrategyBillModuleDto>> export(@RequestBody Search search);


    //写一个方法导入StrategyBillModule
    @PostMapping(path = "uploadStrategyBillModule")
    @ApiOperation(value = "导入StrategyBillModule", notes = "导入StrategyBillModule")
    ResultData<String> uploadStrategyBillModule(@RequestBody List<StrategyBillModuleDto> list) throws Exception;





}
