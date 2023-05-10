package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyModuleRelationDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 经营策略与模块负责人关联表(StrategyModuleRelation)API
 *
 * @author sei
 * @since 2023-05-09 15:12:41
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyModuleRelationApi.PATH)
public interface StrategyModuleRelationApi extends BaseEntityApi<StrategyModuleRelationDto> {
    String PATH = "strategyModuleRelation";
}
