package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.domlin.strategy.dto.StrategyProjectVerifyDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 验证问题(StrategyProjectVerify)API
 *
 * @author sei
 * @since 2023-05-09 15:13:29
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectVerifyApi.PATH)
public interface StrategyProjectVerifyApi extends BaseEntityApi<StrategyProjectVerifyDto> {
    String PATH = "strategyProjectVerify";

    //写一个方法根据确认列别或者确认结果查询strategyProjectVerify，没有条件则查询全部
    @PostMapping(path = "findByPage")
    @ApiOperation("分页查询strategyProjectVerify")
    ResultData<PageResult<StrategyProjectVerifyDto>> findByPage(@RequestBody Search search);

    //写一个方法，update strategyProjectVerify
    @PostMapping(path = "update")
    @ApiOperation("更新strategyProjectVerify")
    ResultData<StrategyProjectVerifyDto> update(@RequestBody StrategyProjectVerifyDto strategyProjectVerify);

    //写一个导出方法，导出全部strategyProjectVerify
    @PostMapping(path = "export")
    @ApiOperation(value = "导出全部strategyProjectVerify", notes = "导出全部strategyProjectVerify")
    ResultData<List<StrategyProjectVerifyDto>> export(@RequestBody Search search);

    //写一个方法导入strategyProjectVerify
    @PostMapping(path = "uploadStrategyProjectVerify")
    @ApiOperation(value = "导入strategyProjectVerify", notes = "导入strategyProjectVerify")
    ResultData<String> uploadStrategyProjectVerify(@RequestBody List<StrategyProjectVerifyDto> list) throws Exception;
}
