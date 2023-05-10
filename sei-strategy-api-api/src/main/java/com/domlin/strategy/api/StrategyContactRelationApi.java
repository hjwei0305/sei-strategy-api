package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyContactRelationDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 经营策略与项目联系人关联表(StrategyContactRelation)API
 *
 * @author sei
 * @since 2023-05-09 15:12:29
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyContactRelationApi.PATH)
public interface StrategyContactRelationApi extends BaseEntityApi<StrategyContactRelationDto> {
    String PATH = "strategyContactRelation";
}
