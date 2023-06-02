package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectSchemeApi;
import com.domlin.strategy.dto.StrategyProjectSchemeDto;
import com.domlin.strategy.entity.StrategyProjectScheme;
import com.domlin.strategy.service.StrategyProjectSchemeService;
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
 * 周期配置(StrategyProjectScheme)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:26
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectSchemeApi", tags = "周期配置服务")
@RequestMapping(path = StrategyProjectSchemeApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectSchemeController extends BaseEntityController<StrategyProjectScheme, StrategyProjectSchemeDto> implements StrategyProjectSchemeApi {
    /**
     * 周期配置服务对象
     */
    @Autowired
    private StrategyProjectSchemeService service;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BaseEntityService<StrategyProjectScheme> getService() {
        return service;
    }

    @Override
    public ResultData<PageResult<StrategyProjectSchemeDto>> findByPage(Search search) {
        PageResult<StrategyProjectSchemeDto> pageResultDto = new PageResult<>();
        PageResult<StrategyProjectScheme> byPage = service.findByPage(search);
        if (CollectionUtils.isNotEmpty(byPage.getRows())){
            List<StrategyProjectSchemeDto> collect = byPage.getRows().stream().map(x -> modelMapper.map(x, StrategyProjectSchemeDto.class)).collect(Collectors.toList());
            pageResultDto.setRows(collect);
            pageResultDto.setTotal(byPage.getTotal());
            pageResultDto.setPage(byPage.getPage());
            pageResultDto.setRecords(byPage.getRecords());
        }
        return ResultData.success(pageResultDto);
    }

    @Override
    public ResultData<StrategyProjectSchemeDto> update(StrategyProjectSchemeDto strategyProjectScheme) {
        if (strategyProjectScheme != null) {
            StrategyProjectScheme update = service.update(modelMapper.map(strategyProjectScheme, StrategyProjectScheme.class));
            return ResultData.success(modelMapper.map(update, StrategyProjectSchemeDto.class));
        }
        return ResultData.fail("参数不能为空");
    }

    @Override
    public ResultData<List<StrategyProjectSchemeDto>> export(Search search) {
        List<StrategyProjectScheme> export = service.findByFilters(search);
        if (CollectionUtils.isNotEmpty(export)){
            List<StrategyProjectSchemeDto> collect = export.stream().map(x -> modelMapper.map(x, StrategyProjectSchemeDto.class)).collect(Collectors.toList());
            return ResultData.success(collect);
        }
        return ResultData.fail("没有数据");
    }

    @Override
    public ResultData<String> uploadStrategyProjectScheme(List<StrategyProjectSchemeDto> list) throws Exception {
        if (CollectionUtils.isNotEmpty(list)){
            List<StrategyProjectScheme> collect = list.stream().map(x -> modelMapper.map(x, StrategyProjectScheme.class)).collect(Collectors.toList());
            return service.uploadStrategyProjectScheme(collect);
        }
        return ResultData.fail("参数不能为空");
    }
}
