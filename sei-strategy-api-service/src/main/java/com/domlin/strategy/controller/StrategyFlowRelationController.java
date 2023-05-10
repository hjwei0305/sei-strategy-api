package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyFlowRelationApi;
import com.domlin.strategy.dto.StrategyFlowRelationDto;
import com.domlin.strategy.entity.StrategyFlowRelation;
import com.domlin.strategy.service.StrategyFlowRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目与流程关联表(StrategyFlowRelation)控制类
 *
 * @author sei
 * @since 2023-05-09 15:12:31
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyFlowRelationApi", tags = "项目与流程关联表服务")
@RequestMapping(path = StrategyFlowRelationApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyFlowRelationController extends BaseEntityController<StrategyFlowRelation, StrategyFlowRelationDto> implements StrategyFlowRelationApi {
    /**
     * 项目与流程关联表服务对象
     */
    @Autowired
    private StrategyFlowRelationService service;

    @Override
    public BaseEntityService<StrategyFlowRelation> getService() {
        return service;
    }

}
