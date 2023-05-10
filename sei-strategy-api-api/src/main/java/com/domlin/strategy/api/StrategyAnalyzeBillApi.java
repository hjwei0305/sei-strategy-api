package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyAnalyzeBillDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 经营策略(StrategyAnalyzeBill)API
 *
 * @author sei
 * @since 2023-05-09 15:10:06
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyAnalyzeBillApi.PATH)
public interface StrategyAnalyzeBillApi extends BaseEntityApi<StrategyAnalyzeBillDto> {
    String PATH = "strategyAnalyzeBill";
}
