package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectChangeUserDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 人员变更表(StrategyProjectChangeUser)API
 *
 * @author sei
 * @since 2023-05-09 15:13:07
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectChangeUserApi.PATH)
public interface StrategyProjectChangeUserApi extends BaseEntityApi<StrategyProjectChangeUserDto> {
    String PATH = "strategyProjectChangeUser";
}
