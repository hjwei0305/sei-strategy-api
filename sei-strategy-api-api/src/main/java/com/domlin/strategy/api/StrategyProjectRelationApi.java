package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectRelationDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 经营策略与项目关联表(StrategyProjectRelation)API
 *
 * @author sei
 * @since 2023-05-09 15:13:25
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectRelationApi.PATH)
public interface StrategyProjectRelationApi extends BaseEntityApi<StrategyProjectRelationDto> {
    String PATH = "strategyProjectRelation";
}
