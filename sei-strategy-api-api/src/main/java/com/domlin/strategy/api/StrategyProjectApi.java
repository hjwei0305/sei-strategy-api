package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 项目(StrategyProject)API
 *
 * @author sei
 * @since 2023-05-09 15:12:51
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectApi.PATH)
public interface StrategyProjectApi extends BaseEntityApi<StrategyProjectDto> {
    String PATH = "strategyProject";
}
