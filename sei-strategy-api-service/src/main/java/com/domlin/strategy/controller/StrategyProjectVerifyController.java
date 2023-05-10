package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectVerifyApi;
import com.domlin.strategy.dto.StrategyProjectVerifyDto;
import com.domlin.strategy.entity.StrategyProjectVerify;
import com.domlin.strategy.service.StrategyProjectVerifyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证问题(StrategyProjectVerify)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:29
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectVerifyApi", tags = "验证问题服务")
@RequestMapping(path = StrategyProjectVerifyApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectVerifyController extends BaseEntityController<StrategyProjectVerify, StrategyProjectVerifyDto> implements StrategyProjectVerifyApi {
    /**
     * 验证问题服务对象
     */
    @Autowired
    private StrategyProjectVerifyService service;

    @Override
    public BaseEntityService<StrategyProjectVerify> getService() {
        return service;
    }

}
