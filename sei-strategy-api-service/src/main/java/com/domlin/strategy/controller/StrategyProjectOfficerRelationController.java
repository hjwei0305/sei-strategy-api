package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectOfficerRelationApi;
import com.domlin.strategy.dto.StrategyProjectOfficerRelationDto;
import com.domlin.strategy.entity.StrategyProjectOfficerRelation;
import com.domlin.strategy.service.StrategyProjectOfficerRelationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目负责人关联表(StrategyProjectOfficerRelation)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:22
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectOfficerRelationApi", tags = "项目负责人关联表服务")
@RequestMapping(path = StrategyProjectOfficerRelationApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectOfficerRelationController extends BaseEntityController<StrategyProjectOfficerRelation, StrategyProjectOfficerRelationDto> implements StrategyProjectOfficerRelationApi {
    /**
     * 项目负责人关联表服务对象
     */
    @Autowired
    private StrategyProjectOfficerRelationService service;

    @Override
    public BaseEntityService<StrategyProjectOfficerRelation> getService() {
        return service;
    }

}
