package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyModuleRelationApi;
import com.domlin.strategy.dto.StrategyModuleRelationDto;
import com.domlin.strategy.entity.StrategyModuleRelation;
import com.domlin.strategy.service.StrategyModuleRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 经营策略与模块负责人关联表(StrategyModuleRelation)控制类
 *
 * @author sei
 * @since 2023-05-09 15:12:36
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyModuleRelationApi", tags = "经营策略与模块负责人关联表服务")
@RequestMapping(path = StrategyModuleRelationApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyModuleRelationController extends BaseEntityController<StrategyModuleRelation, StrategyModuleRelationDto> implements StrategyModuleRelationApi {
    /**
     * 经营策略与模块负责人关联表服务对象
     */
    @Autowired
    private StrategyModuleRelationService service;

    @Override
    public BaseEntityService<StrategyModuleRelation> getService() {
        return service;
    }

}
