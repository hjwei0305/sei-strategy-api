package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyUnitOfficerRelationDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 经营策略与单位负责人关联表(StrategyUnitOfficerRelation)API
 *
 * @author sei
 * @since 2023-05-09 15:13:33
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyUnitOfficerRelationApi.PATH)
public interface StrategyUnitOfficerRelationApi extends BaseEntityApi<StrategyUnitOfficerRelationDto> {
    String PATH = "strategyUnitOfficerRelation";
}
