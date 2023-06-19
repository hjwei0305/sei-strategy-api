package com.domlin.strategy.controller;

import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.api.StrategyProjectChangeApi;
import com.domlin.strategy.constant.StrategyConstant;
import com.domlin.strategy.dto.StrategyProjectChangeDto;
import com.domlin.strategy.entity.StrategyProjectChange;
import com.domlin.strategy.service.StrategyProjectChangeService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * 项目变更表(StrategyProjectChange)控制类
 *
 * @author sei
 * @since 2023-05-09 15:12:52
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyProjectChangeApi", tags = "项目变更表服务")
@RequestMapping(path = StrategyProjectChangeApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyProjectChangeController extends BaseEntityController<StrategyProjectChange, StrategyProjectChangeDto> implements StrategyProjectChangeApi {
    /**
     * 项目变更表服务对象
     */
    @Autowired
    private StrategyProjectChangeService service;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BaseEntityService<StrategyProjectChange> getService() {
        return service;
    }

    @Override
    public ResultData<PageResult<StrategyProjectChangeDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    @Override
    public ResultData<List<StrategyProjectChangeDto>> export(Search search) {
        List<StrategyProjectChange> byFilters = service.findByFilters(search);
        List<StrategyProjectChangeDto> collect = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(byFilters)) {
            for (int i = 0; i < byFilters.size(); i++) {
                StrategyProjectChangeDto map = modelMapper.map(byFilters.get(i), StrategyProjectChangeDto.class);
                if (Objects.equals(map.getChangeStyle(), StrategyConstant.CHANGE)){
                    map.setChangeStyle("变更");
                } else if (Objects.equals(map.getChangeStyle(), StrategyConstant.STOP)) {
                    map.setChangeStyle("停止");
                } else if (Objects.equals(map.getChangeStyle(), StrategyConstant.ABANDON)) {
                    map.setChangeStyle("废弃");
                }
                collect.add(map);
            }
        }
        return ResultData.success(collect);
    }
}
