package com.domlin.strategy.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.domlin.strategy.dto.StrategyProjectContactRelationDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 项目对接人员关联表(StrategyProjectContactRelation)API
 *
 * @author sei
 * @since 2023-05-09 15:13:09
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "sei-strategy-api", path = StrategyProjectContactRelationApi.PATH)
public interface StrategyProjectContactRelationApi extends BaseEntityApi<StrategyProjectContactRelationDto> {
    String PATH = "strategyProjectContactRelation";
}
