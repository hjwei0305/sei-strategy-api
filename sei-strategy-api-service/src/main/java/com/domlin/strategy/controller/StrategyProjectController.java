package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectApi;
import com.domlin.strategy.dto.StrategyProjectDto;
import com.domlin.strategy.entity.StrategyProject;
import com.domlin.strategy.service.StrategyProjectService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目(StrategyProject)控制类
 *
 * @author sei
 * @since 2023-05-09 15:12:50
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectApi", tags = "项目服务")
@RequestMapping(path = StrategyProjectApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectController extends BaseEntityController<StrategyProject, StrategyProjectDto> implements StrategyProjectApi {
    /**
     * 项目服务对象
     */
    @Autowired
    private StrategyProjectService service;

    @Override
    public BaseEntityService<StrategyProject> getService() {
        return service;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResultData<PageResult<StrategyProjectDto>> findByPage(Search search) {
        PageResult<StrategyProjectDto> newPageResult = new PageResult<>();
        List<StrategyProjectDto> newRows = new ArrayList<>();
        PageResult<StrategyProject> pageResult = service.findByPage(search);
        if (CollectionUtils.isNotEmpty(pageResult.getRows())){
            pageResult.getRows().forEach(x -> newRows.add(modelMapper.map(x, StrategyProjectDto.class)));
            newPageResult.setRows(newRows);
            newPageResult.setTotal(pageResult.getTotal());
            newPageResult.setPage(pageResult.getPage());
        }
        return ResultData.success(newPageResult);
    }

    @Override
    public ResultData<StrategyProjectDto> update(StrategyProjectDto strategyProject) {
        if (strategyProject != null) {
            StrategyProject entity = modelMapper.map(strategyProject, StrategyProject.class);
            service.update(entity);
            return ResultData.success(modelMapper.map(entity, StrategyProjectDto.class));
        }
        return ResultData.fail("参数不能为空");
    }

    @Override
    public ResultData<StrategyProjectDto> save(StrategyProjectDto strategyProject) {
        System.out.println("strategyProject = " + strategyProject);
        if (strategyProject != null) {
            StrategyProject entity = modelMapper.map(strategyProject, StrategyProject.class);
            service.save(entity);
            return ResultData.success(modelMapper.map(entity, StrategyProjectDto.class));
        }
        return ResultData.fail("参数不能为空");
    }
}
