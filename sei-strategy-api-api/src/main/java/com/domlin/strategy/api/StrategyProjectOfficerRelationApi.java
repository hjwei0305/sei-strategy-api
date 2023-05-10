package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectOfficerRelationDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 项目负责人关联表(StrategyProjectOfficerRelation)API
 *
 * @author sei
 * @since 2023-05-09 15:13:22
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectOfficerRelationApi.PATH)
public interface StrategyProjectOfficerRelationApi extends BaseEntityApi<StrategyProjectOfficerRelationDto> {
    String PATH = "strategyProjectOfficerRelation";
}
