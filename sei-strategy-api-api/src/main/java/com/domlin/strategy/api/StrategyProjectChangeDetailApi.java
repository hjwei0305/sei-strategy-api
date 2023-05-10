package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectChangeDetailDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 人员变更明细表(StrategyProjectChangeDetail)API
 *
 * @author sei
 * @since 2023-05-09 15:13:01
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectChangeDetailApi.PATH)
public interface StrategyProjectChangeDetailApi extends BaseEntityApi<StrategyProjectChangeDetailDto> {
    String PATH = "strategyProjectChangeDetail";
}
