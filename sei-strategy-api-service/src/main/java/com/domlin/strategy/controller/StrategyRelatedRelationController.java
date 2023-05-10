package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyRelatedRelationApi;
import com.domlin.strategy.dto.StrategyRelatedRelationDto;
import com.domlin.strategy.entity.StrategyRelatedRelation;
import com.domlin.strategy.service.StrategyRelatedRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目相关人员关联表(StrategyRelatedRelation)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:30
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyRelatedRelationApi", tags = "项目相关人员关联表服务")
@RequestMapping(path = StrategyRelatedRelationApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyRelatedRelationController extends BaseEntityController<StrategyRelatedRelation, StrategyRelatedRelationDto> implements StrategyRelatedRelationApi {
    /**
     * 项目相关人员关联表服务对象
     */
    @Autowired
    private StrategyRelatedRelationService service;

    @Override
    public BaseEntityService<StrategyRelatedRelation> getService() {
        return service;
    }

}
