package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectChangeUserApi;
import com.domlin.strategy.dto.StrategyProjectChangeUserDto;
import com.domlin.strategy.entity.StrategyProjectChangeUser;
import com.domlin.strategy.service.StrategyProjectChangeUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 人员变更表(StrategyProjectChangeUser)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:06
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectChangeUserApi", tags = "人员变更表服务")
@RequestMapping(path = StrategyProjectChangeUserApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectChangeUserController extends BaseEntityController<StrategyProjectChangeUser, StrategyProjectChangeUserDto> implements StrategyProjectChangeUserApi {
    /**
     * 人员变更表服务对象
     */
    @Autowired
    private StrategyProjectChangeUserService service;

    @Override
    public BaseEntityService<StrategyProjectChangeUser> getService() {
        return service;
    }

}
