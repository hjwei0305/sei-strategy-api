package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyBillModuleApi;
import com.domlin.strategy.dto.StrategyBillModuleDto;
import com.domlin.strategy.dto.StrategyProjectLevelDto;
import com.domlin.strategy.entity.StrategyBillModule;
import com.domlin.strategy.entity.StrategyProjectLevel;
import com.domlin.strategy.service.StrategyBillModuleService;
import io.swagger.annotations.Api;
import jdk.nashorn.internal.objects.NativeArray;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 经营策略模块(StrategyBillModule)控制类
 *
 * @author sei
 * @since 2023-05-09 15:10:15
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyBillModuleApi", tags = "经营策略模块服务")
@RequestMapping(path = StrategyBillModuleApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyBillModuleController extends BaseEntityController<StrategyBillModule, StrategyBillModuleDto> implements StrategyBillModuleApi {
    /**
     * 经营策略模块服务对象
     */
    @Autowired
    private StrategyBillModuleService service;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BaseEntityService<StrategyBillModule> getService() {
        return service;
    }

    @Override
    public ResultData<PageResult<StrategyBillModuleDto>> findByPage(Search search) {
        PageResult<StrategyBillModuleDto> newPageResult = new PageResult<>();
        List<StrategyBillModuleDto> newRows = new ArrayList<>();
        PageResult<StrategyBillModule> pageResult = service.findByPage(search);
        if (CollectionUtils.isNotEmpty(pageResult.getRows())) {
            pageResult.getRows().forEach(x -> newRows.add(modelMapper.map(x, StrategyBillModuleDto.class)));
            newPageResult.setRows(newRows);
            newPageResult.setTotal(pageResult.getTotal());
            newPageResult.setPage(pageResult.getPage());
            newPageResult.setRecords(pageResult.getRecords());
        }
        return ResultData.success(newPageResult);
    }

    @Override
    public ResultData<StrategyBillModuleDto> update(StrategyBillModuleDto strategyBillModule) {
        if (strategyBillModule == null) {
            StrategyBillModule mode = service.update(modelMapper.map(strategyBillModule, StrategyBillModule.class));
            return ResultData.success(modelMapper.map(mode, StrategyBillModuleDto.class));
        }
        return ResultData.fail("参数不能为空");
    }

    @Override
    public ResultData<List<StrategyBillModuleDto>> export(Search search) {
        List<StrategyBillModule> allOrders = service.findByFilters(search);
        List<StrategyBillModuleDto> collect = null;
        if (CollectionUtils.isNotEmpty(allOrders)) {
            TypeMap<StrategyBillModule, StrategyBillModuleDto> typeMap = modelMapper.typeMap(StrategyBillModule.class, StrategyBillModuleDto.class);
            collect = allOrders.stream().map(typeMap::map).collect(Collectors.toList());
        }
        return ResultData.success(collect);
    }

    @Override
    public ResultData<String> uploadStrategyBillModule(List<StrategyBillModuleDto> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            List<StrategyBillModule> collect = list.stream().map(x -> modelMapper.map(x, StrategyBillModule.class)).collect(Collectors.toList());
            return service.uploadStrategyBillModule(collect);
        }
        return ResultData.success();
    }
}
