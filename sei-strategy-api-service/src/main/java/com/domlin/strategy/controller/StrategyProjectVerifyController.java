package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectVerifyApi;
import com.domlin.strategy.dto.StrategyProjectStyleDto;
import com.domlin.strategy.dto.StrategyProjectVerifyDto;
import com.domlin.strategy.entity.StrategyProjectStyle;
import com.domlin.strategy.entity.StrategyProjectVerify;
import com.domlin.strategy.service.StrategyProjectVerifyService;
import io.swagger.annotations.Api;
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
 * 验证问题(StrategyProjectVerify)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:29
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectVerifyApi", tags = "验证问题服务")
@RequestMapping(path = StrategyProjectVerifyApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectVerifyController extends BaseEntityController<StrategyProjectVerify, StrategyProjectVerifyDto> implements StrategyProjectVerifyApi {
    /**
     * 验证问题服务对象
     */
    @Autowired
    private StrategyProjectVerifyService service;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BaseEntityService<StrategyProjectVerify> getService() {
        return service;
    }

    @Override
    public ResultData<PageResult<StrategyProjectVerifyDto>> findByPage(Search search) {
        PageResult<StrategyProjectVerify> pageResult = service.findByPage(search);
        List<StrategyProjectVerify> newRows = new ArrayList<>();
        PageResult<StrategyProjectVerify> byPage = service.findByPage(search);
        if (CollectionUtils.isNotEmpty(byPage.getRows())) {
            byPage.getRows().forEach(x -> newRows.add(modelMapper.map(x, StrategyProjectVerify.class)));
            pageResult.setRows(newRows);
            pageResult.setTotal(byPage.getTotal());
            pageResult.setPage(byPage.getPage());
            pageResult.setRecords(byPage.getRecords());
        }
        return ResultData.success(modelMapper.map(pageResult, PageResult.class));
    }

    @Override
    public ResultData<StrategyProjectVerifyDto> update(StrategyProjectVerifyDto strategyProjectVerify) {
        if (strategyProjectVerify != null) {
            StrategyProjectVerify update = service.update(modelMapper.map(strategyProjectVerify, StrategyProjectVerify.class));
            return ResultData.success(modelMapper.map(update, StrategyProjectVerifyDto.class));
        }
        return ResultData.fail("参数不能为空");
    }


    @Override
    public ResultData<List<StrategyProjectVerifyDto>> export(Search search) {
        List<StrategyProjectVerify> allOrders = service.findByFilters(search);
        List<StrategyProjectVerifyDto> collect = null;
        if (CollectionUtils.isNotEmpty(allOrders)) {
            TypeMap<StrategyProjectVerify, StrategyProjectVerifyDto> typeMap = modelMapper.typeMap(StrategyProjectVerify.class, StrategyProjectVerifyDto.class);
            collect = allOrders.stream().map(typeMap::map).collect(Collectors.toList());
        }
        return ResultData.success(collect);
    }

    @Override
    public ResultData<String> uploadStrategyProjectVerify(List<StrategyProjectVerifyDto> list) {
        if(CollectionUtils.isNotEmpty(list)){
            List<StrategyProjectVerify> collect = list.stream().map(x -> modelMapper.map(x, StrategyProjectVerify.class)).collect(Collectors.toList());
            return service.uploadStrategyProjectVerify(collect);
        }
        return ResultData.success();
    }
}
