package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectLevelApi;
import com.domlin.strategy.dto.StrategyProjectLevelDto;
import com.domlin.strategy.entity.StrategyProjectLevel;
import com.domlin.strategy.service.StrategyProjectLevelService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目分级(StrategyProjectLevel)控制类
 *
 * @author wake
 * @since 2023-05-09 15:13:19
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectLevelApi", tags = "项目分级服务")
@RequestMapping(path = StrategyProjectLevelApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectLevelController extends BaseEntityController<StrategyProjectLevel, StrategyProjectLevelDto> implements StrategyProjectLevelApi {
    /**
     * 项目分级服务对象
     */
    @Autowired
    private StrategyProjectLevelService service;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BaseEntityService<StrategyProjectLevel> getService() {
        return service;
    }


    @Override
    public ResultData<PageResult<StrategyProjectLevelDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    @Override
    public ResultData<StrategyProjectLevelDto> update(StrategyProjectLevelDto strategyProjectLevel) {
        if (strategyProjectLevel != null) {
            StrategyProjectLevel update = service.update(modelMapper.map(strategyProjectLevel, StrategyProjectLevel.class));
            return ResultData.success(modelMapper.map(update, StrategyProjectLevelDto.class));
        }
        return ResultData.fail("参数不能为空");
    }

    @Override
    public ResultData<List<StrategyProjectLevelDto>> export(Search search) {
        List<StrategyProjectLevel> allOrders = service.findByFilters(search);
        List<StrategyProjectLevelDto> collect = null;
        if (CollectionUtils.isNotEmpty(allOrders)) {
            TypeMap<StrategyProjectLevel, StrategyProjectLevelDto> typeMap = modelMapper.typeMap(StrategyProjectLevel.class, StrategyProjectLevelDto.class);
            collect = allOrders.stream().map(typeMap::map).collect(Collectors.toList());
        }
        return ResultData.success(collect);
    }

    @Override
    public ResultData<String> uploadStrategyProjectLevel(List<StrategyProjectLevelDto> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            List<StrategyProjectLevel> collect = list.stream().map(x -> modelMapper.map(x, StrategyProjectLevel.class)).collect(Collectors.toList());
            return service.uploadStrategyProjectLevel(collect);
        }
        return ResultData.success();
    }

}
