package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyManageRelationDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 经营策略与管理组关联表(StrategyManageRelation)API
 *
 * @author sei
 * @since 2023-05-09 15:12:34
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyManageRelationApi.PATH)
public interface StrategyManageRelationApi extends BaseEntityApi<StrategyManageRelationDto> {
    String PATH = "strategyManageRelation";
}
