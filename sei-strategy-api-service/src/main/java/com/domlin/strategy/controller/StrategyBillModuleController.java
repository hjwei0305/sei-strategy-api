package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyBillModuleApi;
import com.domlin.strategy.dto.StrategyBillModuleDto;
import com.domlin.strategy.entity.StrategyBillModule;
import com.domlin.strategy.service.StrategyBillModuleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 经营策略模块(StrategyBillModule)控制类
 *
 * @author sei
 * @since 2023-05-09 15:10:15
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyBillModuleApi", tags = "经营策略模块服务")
@RequestMapping(path = StrategyBillModuleApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyBillModuleController extends BaseEntityController<StrategyBillModule, StrategyBillModuleDto> implements StrategyBillModuleApi {
    /**
     * 经营策略模块服务对象
     */
    @Autowired
    private StrategyBillModuleService service;

    @Override
    public BaseEntityService<StrategyBillModule> getService() {
        return service;
    }

}
