package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectRelationApi;
import com.domlin.strategy.dto.StrategyProjectRelationDto;
import com.domlin.strategy.entity.StrategyProjectRelation;
import com.domlin.strategy.service.StrategyProjectRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 经营策略与项目关联表(StrategyProjectRelation)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:24
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectRelationApi", tags = "经营策略与项目关联表服务")
@RequestMapping(path = StrategyProjectRelationApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectRelationController extends BaseEntityController<StrategyProjectRelation, StrategyProjectRelationDto> implements StrategyProjectRelationApi {
    /**
     * 经营策略与项目关联表服务对象
     */
    @Autowired
    private StrategyProjectRelationService service;

    @Override
    public BaseEntityService<StrategyProjectRelation> getService() {
        return service;
    }

}
