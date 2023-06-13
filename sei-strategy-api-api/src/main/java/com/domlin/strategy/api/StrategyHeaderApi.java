package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.domlin.strategy.dto.StrategyAnalyzeBillDto;
import com.domlin.strategy.dto.StrategyHeaderDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


/**
 * 经营策略(StrategyAnalyzeBill)API
 *
 * @author wake
 * @since 2023-05-09 15:10:06
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategyHeader-api", path = StrategyHeaderApi.PATH)
public interface StrategyHeaderApi extends BaseEntityApi<StrategyHeaderDto> {
    String PATH = "strategyHeaderApi";


    //写一个方法，分页查询StrategyHeaderDto
    @PostMapping(path = "findByPage")
    @ApiOperation("分页查询StrategyHeaderDto")
    ResultData<PageResult<StrategyHeaderDto>> findByPage(@RequestBody Search search);


    //写一个方法，更新strategyAnalyzeBill，并且保存strategyProject
    @PostMapping(path = "updateStrategyAnalyzeBillAndProject")
    @ApiOperation(value = "更新strategyAnalyzeBill，并且保存strategyProject", notes = "更新strategyAnalyzeBill，并且保存strategyProject")
    ResultData<StrategyHeaderDto> updateStrategyAnalyzeBillAndProject(@RequestBody StrategyHeaderDto strategyHeaderDto) throws Exception;


}
