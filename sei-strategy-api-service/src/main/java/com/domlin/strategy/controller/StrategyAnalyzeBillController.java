package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyAnalyzeBillApi;
import com.domlin.strategy.dto.StrategyAnalyzeBillDto;
import com.domlin.strategy.entity.StrategyAnalyzeBill;
import com.domlin.strategy.service.StrategyAnalyzeBillService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 经营策略(StrategyAnalyzeBill)控制类
 *
 * @author sei
 * @since 2023-05-09 15:09:58
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyAnalyzeBillApi", tags = "经营策略服务")
@RequestMapping(path = StrategyAnalyzeBillApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyAnalyzeBillController extends BaseEntityController<StrategyAnalyzeBill, StrategyAnalyzeBillDto> implements StrategyAnalyzeBillApi {
    /**
     * 经营策略服务对象
     */
    @Autowired
    private StrategyAnalyzeBillService service;

    @Override
    public BaseEntityService<StrategyAnalyzeBill> getService() {
        return service;
    }

}
