package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectSchemeApi;
import com.domlin.strategy.dto.StrategyProjectSchemeDto;
import com.domlin.strategy.entity.StrategyProjectScheme;
import com.domlin.strategy.service.StrategyProjectSchemeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 周期配置(StrategyProjectScheme)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:26
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectSchemeApi", tags = "周期配置服务")
@RequestMapping(path = StrategyProjectSchemeApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectSchemeController extends BaseEntityController<StrategyProjectScheme, StrategyProjectSchemeDto> implements StrategyProjectSchemeApi {
    /**
     * 周期配置服务对象
     */
    @Autowired
    private StrategyProjectSchemeService service;

    @Override
    public BaseEntityService<StrategyProjectScheme> getService() {
        return service;
    }

}
