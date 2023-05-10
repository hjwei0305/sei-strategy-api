package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectChangeDetailApi;
import com.domlin.strategy.dto.StrategyProjectChangeDetailDto;
import com.domlin.strategy.entity.StrategyProjectChangeDetail;
import com.domlin.strategy.service.StrategyProjectChangeDetailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 人员变更明细表(StrategyProjectChangeDetail)控制类
 *
 * @author sei
 * @since 2023-05-09 15:12:59
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectChangeDetailApi", tags = "人员变更明细表服务")
@RequestMapping(path = StrategyProjectChangeDetailApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectChangeDetailController extends BaseEntityController<StrategyProjectChangeDetail, StrategyProjectChangeDetailDto> implements StrategyProjectChangeDetailApi {
    /**
     * 人员变更明细表服务对象
     */
    @Autowired
    private StrategyProjectChangeDetailService service;

    @Override
    public BaseEntityService<StrategyProjectChangeDetail> getService() {
        return service;
    }

}
