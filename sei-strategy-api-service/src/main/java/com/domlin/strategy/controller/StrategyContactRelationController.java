package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyContactRelationApi;
import com.domlin.strategy.dto.StrategyContactRelationDto;
import com.domlin.strategy.entity.StrategyContactRelation;
import com.domlin.strategy.service.StrategyContactRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 经营策略与项目联系人关联表(StrategyContactRelation)控制类
 *
 * @author sei
 * @since 2023-05-09 15:12:23
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyContactRelationApi", tags = "经营策略与项目联系人关联表服务")
@RequestMapping(path = StrategyContactRelationApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyContactRelationController extends BaseEntityController<StrategyContactRelation, StrategyContactRelationDto> implements StrategyContactRelationApi {
    /**
     * 经营策略与项目联系人关联表服务对象
     */
    @Autowired
    private StrategyContactRelationService service;

    @Override
    public BaseEntityService<StrategyContactRelation> getService() {
        return service;
    }

}
