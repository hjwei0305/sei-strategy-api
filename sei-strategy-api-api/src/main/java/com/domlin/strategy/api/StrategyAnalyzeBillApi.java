package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.domlin.strategy.dto.StrategyAnalyzeBillDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 经营策略(StrategyAnalyzeBill)API
 *
 * @author wake
 * @since 2023-05-09 15:10:06
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyAnalyzeBillApi.PATH)
public interface StrategyAnalyzeBillApi extends BaseEntityApi<StrategyAnalyzeBillDto> {
    String PATH = "strategyAnalyzeBill";

    //写一个方法，分页查询strategyAnalyzeBill
    @PostMapping(path = "findByPage")
    @ApiOperation("分页查询strategyAnalyzeBill")
    ResultData<PageResult<StrategyAnalyzeBillDto>> findByPage(@RequestBody Search search);

    //写一个方法，update strategyAnalyzeBill
    @PostMapping(path = "update")
    @ApiOperation("更新strategyAnalyzeBill")
    ResultData<StrategyAnalyzeBillDto> update(@RequestBody StrategyAnalyzeBillDto strategyAnalyzeBill);

    //写一个导出方法，导出全部strategyAnalyzeBill
    @PostMapping(path = "export")
    @ApiOperation(value = "导出全部strategyAnalyzeBill", notes = "导出全部strategyAnalyzeBill")
    ResultData<List<StrategyAnalyzeBillDto>> export(@RequestBody Search search);


    //写一个方法导入strategyAnalyzeBill
    @PostMapping(path = "uploadStrategyAnalyzeBill")
    @ApiOperation(value = "导入strategyAnalyzeBill", notes = "导入strategyAnalyzeBill")
    ResultData<String> uploadStrategyAnalyzeBill(@RequestBody StrategyAnalyzeBillDto strategyAnalyzeBill) throws Exception;



}
