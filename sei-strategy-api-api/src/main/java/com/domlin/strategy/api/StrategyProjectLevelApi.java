package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectLevelDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 项目分级(StrategyProjectLevel)API
 *
 * @author sei
 * @since 2023-05-09 15:13:20
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectLevelApi.PATH)
public interface StrategyProjectLevelApi extends BaseEntityApi<StrategyProjectLevelDto> {
    String PATH = "strategyProjectLevel";
}
