package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectStyleApi;
import com.domlin.strategy.dto.StrategyProjectStyleDto;
import com.domlin.strategy.entity.StrategyProjectStyle;
import com.domlin.strategy.service.StrategyProjectStyleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目类别(StrategyProjectStyle)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:27
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectStyleApi", tags = "项目类别服务")
@RequestMapping(path = StrategyProjectStyleApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectStyleController extends BaseEntityController<StrategyProjectStyle, StrategyProjectStyleDto> implements StrategyProjectStyleApi {
    /**
     * 项目类别服务对象
     */
    @Autowired
    private StrategyProjectStyleService service;

    @Override
    public BaseEntityService<StrategyProjectStyle> getService() {
        return service;
    }

}
