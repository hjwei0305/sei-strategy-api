package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectContactRelationApi;
import com.domlin.strategy.dto.StrategyProjectContactRelationDto;
import com.domlin.strategy.entity.StrategyProjectContactRelation;
import com.domlin.strategy.service.StrategyProjectContactRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目对接人员关联表(StrategyProjectContactRelation)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:08
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectContactRelationApi", tags = "项目对接人员关联表服务")
@RequestMapping(path = StrategyProjectContactRelationApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectContactRelationController extends BaseEntityController<StrategyProjectContactRelation, StrategyProjectContactRelationDto> implements StrategyProjectContactRelationApi {
    /**
     * 项目对接人员关联表服务对象
     */
    @Autowired
    private StrategyProjectContactRelationService service;

    @Override
    public BaseEntityService<StrategyProjectContactRelation> getService() {
        return service;
    }

}
