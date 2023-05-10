package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyRelatedRelationDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 项目相关人员关联表(StrategyRelatedRelation)API
 *
 * @author sei
 * @since 2023-05-09 15:13:31
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyRelatedRelationApi.PATH)
public interface StrategyRelatedRelationApi extends BaseEntityApi<StrategyRelatedRelationDto> {
    String PATH = "strategyRelatedRelation";
}
