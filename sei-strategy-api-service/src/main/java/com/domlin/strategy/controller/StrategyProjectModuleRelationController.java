package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectModuleRelationApi;
import com.domlin.strategy.dto.StrategyProjectModuleRelationDto;
import com.domlin.strategy.entity.StrategyProjectModuleRelation;
import com.domlin.strategy.service.StrategyProjectModuleRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目与模块关联表(StrategyProjectModuleRelation)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:21
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectModuleRelationApi", tags = "项目与模块关联表服务")
@RequestMapping(path = StrategyProjectModuleRelationApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectModuleRelationController extends BaseEntityController<StrategyProjectModuleRelation, StrategyProjectModuleRelationDto> implements StrategyProjectModuleRelationApi {
    /**
     * 项目与模块关联表服务对象
     */
    @Autowired
    private StrategyProjectModuleRelationService service;

    @Override
    public BaseEntityService<StrategyProjectModuleRelation> getService() {
        return service;
    }

}
