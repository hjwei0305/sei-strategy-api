package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectChangeDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 项目变更表(StrategyProjectChange)API
 *
 * @author sei
 * @since 2023-05-09 15:12:57
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectChangeApi.PATH)
public interface StrategyProjectChangeApi extends BaseEntityApi<StrategyProjectChangeDto> {
    String PATH = "strategyProjectChange";
}
