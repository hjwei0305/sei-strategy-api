package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.domlin.strategy.dto.StrategyProjectLevelDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 项目分级(StrategyProjectLevel)API
 *
 * @author wake
 * @since 2023-05-09 15:13:20
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectLevelApi.PATH)
public interface StrategyProjectLevelApi extends BaseEntityApi<StrategyProjectLevelDto> {
    String PATH = "strategyProjectLevel";

    //写一个方法分页查询项目分级，按照级别或者创建者或者创建日期为查询条件
    @PostMapping(path = "findByPage")
    @ApiOperation("分页查询项目分级")
    ResultData<PageResult<StrategyProjectLevelDto>> findByPage(@RequestBody Search search);

    //写一个方法，update strategyProjectLevel
    @PostMapping(path = "update")
    @ApiOperation("更新项目分级")
    ResultData<StrategyProjectLevelDto> update(@RequestBody StrategyProjectLevelDto strategyProjectLevel);

    //写一个导出方法，导出全部strategyProjectLevel
    @PostMapping(path = "export")
    @ApiOperation(value = "导出全部项目分级", notes = "导出全部项目分级")
    ResultData<List<StrategyProjectLevelDto>> export(@RequestBody Search search);

    //写一个方法导入strategyProjectLevel
    @PostMapping(path = "uploadStrategyProjectLevel")
    @ApiOperation(value = "导入项目分级", notes = "导入项目分级")
    ResultData<String> uploadStrategyProjectLevel(@RequestBody List<StrategyProjectLevelDto> list) throws Exception;

}
