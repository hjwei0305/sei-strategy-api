package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectModuleRelationDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 项目与模块关联表(StrategyProjectModuleRelation)API
 *
 * @author sei
 * @since 2023-05-09 15:13:21
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectModuleRelationApi.PATH)
public interface StrategyProjectModuleRelationApi extends BaseEntityApi<StrategyProjectModuleRelationDto> {
    String PATH = "strategyProjectModuleRelation";
}
