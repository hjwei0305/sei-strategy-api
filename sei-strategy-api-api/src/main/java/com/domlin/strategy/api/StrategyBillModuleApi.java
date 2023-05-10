package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyBillModuleDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 经营策略模块(StrategyBillModule)API
 *
 * @author sei
 * @since 2023-05-09 15:10:16
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyBillModuleApi.PATH)
public interface StrategyBillModuleApi extends BaseEntityApi<StrategyBillModuleDto> {
    String PATH = "strategyBillModule";
}
