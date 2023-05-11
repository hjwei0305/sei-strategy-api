package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.domlin.strategy.dto.StrategyProjectStyleDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * 项目类别(StrategyProjectStyle)API
 *
 * @author sei
 * @since 2023-05-09 15:13:28
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectStyleApi.PATH)
public interface StrategyProjectStyleApi extends BaseEntityApi<StrategyProjectStyleDto> {
    String PATH = "strategyProjectStyle";

    //写一个方法，新增strategyProjectStyle
    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("新增strategyProjectStyle")
    ResultData<StrategyProjectStyleDto> save(@RequestBody StrategyProjectStyleDto strategyProjectStyle);

    //写一个方法查询strategyProjectStyle，根据类别名称或者code，没有条件则查询全部
    @PostMapping(path = "findByPage", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("分页查询strategyProjectStyle")
    ResultData<PageResult<StrategyProjectStyleDto>> findByPage(@RequestBody Search search);



}
