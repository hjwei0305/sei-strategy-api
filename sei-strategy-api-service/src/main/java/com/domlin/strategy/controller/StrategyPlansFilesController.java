package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyPlansFilesApi;
import com.domlin.strategy.dto.StrategyPlansFilesDto;
import com.domlin.strategy.entity.StrategyPlansFiles;
import com.domlin.strategy.service.StrategyPlansFilesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目与文件关联表(StrategyPlansFiles)控制类
 *
 * @author sei
 * @since 2023-05-09 15:12:43
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyPlansFilesApi", tags = "项目与文件关联表服务")
@RequestMapping(path = StrategyPlansFilesApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyPlansFilesController extends BaseEntityController<StrategyPlansFiles, StrategyPlansFilesDto> implements StrategyPlansFilesApi {
    /**
     * 项目与文件关联表服务对象
     */
    @Autowired
    private StrategyPlansFilesService service;

    @Override
    public BaseEntityService<StrategyPlansFiles> getService() {
        return service;
    }

}
