package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyUserApi;
import com.domlin.strategy.dto.StrategyUserDto;
import com.domlin.strategy.entity.StrategyUser;
import com.domlin.strategy.service.StrategyUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 人员信息(StrategyUser)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:33
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyUserApi", tags = "人员信息服务")
@RequestMapping(path = StrategyUserApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyUserController extends BaseEntityController<StrategyUser, StrategyUserDto> implements StrategyUserApi {
    /**
     * 人员信息服务对象
     */
    @Autowired
    private StrategyUserService service;

    @Override
    public BaseEntityService<StrategyUser> getService() {
        return service;
    }

}
