package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyManageRelationApi;
import com.domlin.strategy.dto.StrategyManageRelationDto;
import com.domlin.strategy.entity.StrategyManageRelation;
import com.domlin.strategy.service.StrategyManageRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 经营策略与管理组关联表(StrategyManageRelation)控制类
 *
 * @author sei
 * @since 2023-05-09 15:12:33
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyManageRelationApi", tags = "经营策略与管理组关联表服务")
@RequestMapping(path = StrategyManageRelationApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyManageRelationController extends BaseEntityController<StrategyManageRelation, StrategyManageRelationDto> implements StrategyManageRelationApi {
    /**
     * 经营策略与管理组关联表服务对象
     */
    @Autowired
    private StrategyManageRelationService service;

    @Override
    public BaseEntityService<StrategyManageRelation> getService() {
        return service;
    }

}
