package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectStyleApi;
import com.domlin.strategy.dto.StrategyProjectStyleDto;
import com.domlin.strategy.entity.StrategyProjectStyle;
import com.domlin.strategy.service.StrategyProjectStyleService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 项目类别(StrategyProjectStyle)控制类
 *
 * @author wake
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
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BaseEntityService<StrategyProjectStyle> getService() {
        return service;
    }


    @Override
    public ResultData<PageResult<StrategyProjectStyleDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    @Override
    public ResultData<StrategyProjectStyleDto> update(StrategyProjectStyleDto strategyProjectStyle) {
        if (Objects.nonNull(strategyProjectStyle)) {
            StrategyProjectStyle update = service.update(modelMapper.map(strategyProjectStyle, StrategyProjectStyle.class));
            return ResultData.success(modelMapper.map(update, StrategyProjectStyleDto.class));
        }
        return ResultData.fail("参数不能为空");
    }


    @Override
    public ResultData<List<StrategyProjectStyleDto>> export(Search search) {
        List<StrategyProjectStyle> allOrders = service.findByFilters(search);
        List<StrategyProjectStyleDto> collect = null;
        if (CollectionUtils.isNotEmpty(allOrders)) {
            TypeMap<StrategyProjectStyle, StrategyProjectStyleDto> typeMap = modelMapper.typeMap(StrategyProjectStyle.class, StrategyProjectStyleDto.class);
            collect = allOrders.stream().map(typeMap::map).collect(Collectors.toList());
        }
        return ResultData.success(collect);
    }


    @Override
    public ResultData<String> uploadStrategyProjectStyle(List<StrategyProjectStyleDto> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            List<StrategyProjectStyle> collect = list.stream().map(x -> modelMapper.map(x, StrategyProjectStyle.class)).collect(Collectors.toList());
            return  service.uploadStrategyProjectStyle(collect);
        }
        return ResultData.success();
    }


}
