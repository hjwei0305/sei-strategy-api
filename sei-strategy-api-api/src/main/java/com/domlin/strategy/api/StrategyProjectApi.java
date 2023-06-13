package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.domlin.strategy.dto.StrategyProjectDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 项目(StrategyProject)API
 *
 * @author wake
 * @since 2023-05-09 15:12:51
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectApi.PATH)
public interface StrategyProjectApi extends BaseEntityApi<StrategyProjectDto> {
    String PATH = "strategyProject";

    //分页查询
    //写一个方法查询StrategyProject，根据项目名称或者code，没有条件则查询全部
    @PostMapping(path = "findByPage",consumes = "application/json")
    @ApiOperation("分页查询StrategyProject")
    ResultData<PageResult<StrategyProjectDto>> findByPage(@RequestBody Search search);

    //写一个方法，update StrategyProject
    @PostMapping(path = "update",consumes = "application/json")
    @ApiOperation("更新StrategyProject")
    ResultData<StrategyProjectDto> update(@RequestBody StrategyProjectDto strategyProject);

}
