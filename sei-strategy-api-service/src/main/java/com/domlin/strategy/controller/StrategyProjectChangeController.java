package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectChangeApi;
import com.domlin.strategy.dto.StrategyProjectChangeDto;
import com.domlin.strategy.entity.StrategyProjectChange;
import com.domlin.strategy.service.StrategyProjectChangeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目变更表(StrategyProjectChange)控制类
 *
 * @author sei
 * @since 2023-05-09 15:12:52
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectChangeApi", tags = "项目变更表服务")
@RequestMapping(path = StrategyProjectChangeApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectChangeController extends BaseEntityController<StrategyProjectChange, StrategyProjectChangeDto> implements StrategyProjectChangeApi {
    /**
     * 项目变更表服务对象
     */
    @Autowired
    private StrategyProjectChangeService service;

    @Override
    public BaseEntityService<StrategyProjectChange> getService() {
        return service;
    }

}
