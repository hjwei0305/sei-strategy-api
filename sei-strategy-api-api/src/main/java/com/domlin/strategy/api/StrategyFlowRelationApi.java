package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyFlowRelationDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 项目与流程关联表(StrategyFlowRelation)API
 *
 * @author sei
 * @since 2023-05-09 15:12:32
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyFlowRelationApi.PATH)
public interface StrategyFlowRelationApi extends BaseEntityApi<StrategyFlowRelationDto> {
    String PATH = "strategyFlowRelation";
}
