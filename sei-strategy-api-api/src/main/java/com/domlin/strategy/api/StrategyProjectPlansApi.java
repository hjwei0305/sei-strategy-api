package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.core.dto.ResultData;
import com.domlin.strategy.dto.StrategyProjectPlansDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 行动计划表单(StrategyProjectPlans)API
 *
 * @author sei
 * @since 2023-05-09 15:13:24
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectPlansApi.PATH)
public interface StrategyProjectPlansApi extends BaseEntityApi<StrategyProjectPlansDto> {
    String PATH = "strategyProjectPlans";

    // 写一个方法，导入strategyProjectPlans
    @PostMapping(path = "uploadStrategyProjectPlans")
    @ApiOperation(value = "导入strategyProjectPlans", notes = "导入strategyProjectPlans")
    ResultData<String> uploadStrategyProjectPlans(@RequestBody List<StrategyProjectPlansDto> strategyProjectPlans) throws Exception;
}
