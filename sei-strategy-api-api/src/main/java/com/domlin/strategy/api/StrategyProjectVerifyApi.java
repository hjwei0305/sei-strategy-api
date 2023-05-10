package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectVerifyDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

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
}
