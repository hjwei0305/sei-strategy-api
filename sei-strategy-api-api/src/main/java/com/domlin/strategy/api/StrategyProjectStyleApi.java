package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectStyleDto;
import org.springframework.cloud.openfeign.FeignClient;

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
}
