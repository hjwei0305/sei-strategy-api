package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyUserDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 人员信息(StrategyUser)API
 *
 * @author sei
 * @since 2023-05-09 15:13:34
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyUserApi.PATH)
public interface StrategyUserApi extends BaseEntityApi<StrategyUserDto> {
    String PATH = "strategyUser";
}
