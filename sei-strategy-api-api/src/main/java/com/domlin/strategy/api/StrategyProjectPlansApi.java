package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectPlansDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

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
}
