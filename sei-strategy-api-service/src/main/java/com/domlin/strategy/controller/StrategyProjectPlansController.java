package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectPlansApi;
import com.domlin.strategy.dto.StrategyProjectPlansDto;
import com.domlin.strategy.entity.StrategyProjectPlans;
import com.domlin.strategy.service.StrategyProjectPlansService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 行动计划表单(StrategyProjectPlans)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:23
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectPlansApi", tags = "行动计划表单服务")
@RequestMapping(path = StrategyProjectPlansApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectPlansController extends BaseEntityController<StrategyProjectPlans, StrategyProjectPlansDto> implements StrategyProjectPlansApi {
    /**
     * 行动计划表单服务对象
     */
    @Autowired
    private StrategyProjectPlansService service;

    @Override
    public BaseEntityService<StrategyProjectPlans> getService() {
        return service;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResultData<String> uploadStrategyProjectPlans(List<StrategyProjectPlansDto> strategyProjectPlans) throws Exception {
        if(CollectionUtils.isNotEmpty(strategyProjectPlans)){
            List<StrategyProjectPlans> collect = strategyProjectPlans.stream().map(x -> modelMapper.map(x, StrategyProjectPlans.class)).collect(Collectors.toList());
            service.uploadStrategyProjectPlans(collect);
        }
        return ResultData.success();
    }
}
