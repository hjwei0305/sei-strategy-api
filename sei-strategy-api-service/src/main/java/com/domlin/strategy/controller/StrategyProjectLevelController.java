package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectLevelApi;
import com.domlin.strategy.dto.StrategyProjectLevelDto;
import com.domlin.strategy.entity.StrategyProjectLevel;
import com.domlin.strategy.service.StrategyProjectLevelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目分级(StrategyProjectLevel)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:19
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectLevelApi", tags = "项目分级服务")
@RequestMapping(path = StrategyProjectLevelApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectLevelController extends BaseEntityController<StrategyProjectLevel, StrategyProjectLevelDto> implements StrategyProjectLevelApi {
    /**
     * 项目分级服务对象
     */
    @Autowired
    private StrategyProjectLevelService service;

    @Override
    public BaseEntityService<StrategyProjectLevel> getService() {
        return service;
    }

}
