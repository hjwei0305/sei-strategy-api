package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectFilesApi;
import com.domlin.strategy.dto.StrategyProjectFilesDto;
import com.domlin.strategy.entity.StrategyProjectFiles;
import com.domlin.strategy.service.StrategyProjectFilesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目与文件关联表(StrategyProjectFiles)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:17
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectFilesApi", tags = "项目与文件关联表服务")
@RequestMapping(path = StrategyProjectFilesApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectFilesController extends BaseEntityController<StrategyProjectFiles, StrategyProjectFilesDto> implements StrategyProjectFilesApi {
    /**
     * 项目与文件关联表服务对象
     */
    @Autowired
    private StrategyProjectFilesService service;

    @Override
    public BaseEntityService<StrategyProjectFiles> getService() {
        return service;
    }

}
