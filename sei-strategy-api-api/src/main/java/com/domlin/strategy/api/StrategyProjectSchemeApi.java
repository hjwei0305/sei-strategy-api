package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.domlin.strategy.dto.StrategyProjectSchemeDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 周期配置(StrategyProjectScheme)API
 *
 * @author wake
 * @since 2023-05-09 15:13:26
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectSchemeApi.PATH)
public interface StrategyProjectSchemeApi extends BaseEntityApi<StrategyProjectSchemeDto> {
    String PATH = "strategyProjectScheme";

    //写一个分页查询
    @PostMapping(path = "findByPage")
    @ApiOperation("分页查询strategyProjectScheme")
    ResultData<PageResult<StrategyProjectSchemeDto>> findByPage(@RequestBody Search search);

    //写一个方法，update strategyProjectScheme
    @PostMapping(path = "update")
    @ApiOperation("更新strategyProjectScheme")
    ResultData<StrategyProjectSchemeDto> update(@RequestBody StrategyProjectSchemeDto strategyProjectScheme);

    //写一个导出方法，导出全部strategyProjectScheme
    @PostMapping(path = "export")
    @ApiOperation(value = "导出全部strategyProjectScheme", notes = "导出全部strategyProjectScheme")
    ResultData<List<StrategyProjectSchemeDto>> export(@RequestBody Search search);

    //写一个方法导入strategyProjectScheme
    @PostMapping(path = "uploadStrategyProjectScheme")
    @ApiOperation(value = "导入strategyProjectScheme", notes = "导入strategyProjectScheme")
    ResultData<String> uploadStrategyProjectScheme(@RequestBody List<StrategyProjectSchemeDto> list) throws Exception;

}
