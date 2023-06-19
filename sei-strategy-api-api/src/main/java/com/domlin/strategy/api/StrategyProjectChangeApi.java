package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.api.FindByPageApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.Search;
import com.domlin.strategy.dto.StrategyProjectChangeDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 项目变更表(StrategyProjectChange)API
 *
 * @author sei
 * @since 2023-05-09 15:12:57
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectChangeApi.PATH)
public interface StrategyProjectChangeApi extends BaseEntityApi<StrategyProjectChangeDto>, FindByPageApi<StrategyProjectChangeDto> {
    String PATH = "strategyProjectChange";


    //写一个导出方法，导出全部StrategyProjectChangeDto
    @PostMapping(path = "export",consumes = "application/json")
    @ApiOperation(value = "导出全部StrategyProjectChangeDto", notes = "导出全部StrategyProjectChangeDto")
    ResultData<List<StrategyProjectChangeDto>> export(@RequestBody Search search);
}
