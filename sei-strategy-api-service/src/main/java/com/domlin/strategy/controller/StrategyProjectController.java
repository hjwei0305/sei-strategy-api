package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectApi;
import com.domlin.strategy.dto.StrategyProjectDto;
import com.domlin.strategy.entity.StrategyProject;
import com.domlin.strategy.service.StrategyProjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目(StrategyProject)控制类
 *
 * @author sei
 * @since 2023-05-09 15:12:50
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectApi", tags = "项目服务")
@RequestMapping(path = StrategyProjectApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectController extends BaseEntityController<StrategyProject, StrategyProjectDto> implements StrategyProjectApi {
    /**
     * 项目服务对象
     */
    @Autowired
    private StrategyProjectService service;

    @Override
    public BaseEntityService<StrategyProject> getService() {
        return service;
    }

}
