package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyUnitOfficerRelationApi;
import com.domlin.strategy.dto.StrategyUnitOfficerRelationDto;
import com.domlin.strategy.entity.StrategyUnitOfficerRelation;
import com.domlin.strategy.service.StrategyUnitOfficerRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 经营策略与单位负责人关联表(StrategyUnitOfficerRelation)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:32
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyUnitOfficerRelationApi", tags = "经营策略与单位负责人关联表服务")
@RequestMapping(path = StrategyUnitOfficerRelationApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyUnitOfficerRelationController extends BaseEntityController<StrategyUnitOfficerRelation, StrategyUnitOfficerRelationDto> implements StrategyUnitOfficerRelationApi {
    /**
     * 经营策略与单位负责人关联表服务对象
     */
    @Autowired
    private StrategyUnitOfficerRelationService service;

    @Override
    public BaseEntityService<StrategyUnitOfficerRelation> getService() {
        return service;
    }

}
