package com.domlin.strategy.controller;

import com.changhong.sei.basic.api.SysUserApi;
import com.changhong.sei.basic.dto.SysUserDto;
import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.serial.sdk.SerialService;
import com.domlin.strategy.api.StrategyAnalyzeBillApi;
import com.domlin.strategy.dto.StrategyAnalyzeBillDto;
import com.domlin.strategy.entity.StrategyAnalyzeBill;
import com.domlin.strategy.service.StrategyAnalyzeBillService;
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
 * 经营策略(StrategyAnalyzeBill)控制类
 *
 * @author sei
 * @since 2023-05-09 15:09:58
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyAnalyzeBillApi", tags = "经营策略服务")
@RequestMapping(path = StrategyAnalyzeBillApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyAnalyzeBillController extends BaseEntityController<StrategyAnalyzeBill, StrategyAnalyzeBillDto> implements StrategyAnalyzeBillApi {
    /**
     * 经营策略服务对象
     */
    @Autowired
    private StrategyAnalyzeBillService service;

    @Override
    public BaseEntityService<StrategyAnalyzeBill> getService() {
        return service;
    }

    @Autowired
    private ModelMapper modelMapper;


    @Autowired(required = false)
    private SerialService serialService;


    /**
     * 分页查询经营策略
     * 封装返回值
     * @param search
     * @return
     */
    @Override
    public ResultData<PageResult<StrategyAnalyzeBillDto>> findByPage(Search search) {
        PageResult<StrategyAnalyzeBillDto> newPageResult = new PageResult<>();
        List<StrategyAnalyzeBillDto> newRows = new ArrayList<>();
        PageResult<StrategyAnalyzeBill> pageResult = service.findByPage(search);
        ArrayList<StrategyAnalyzeBill> rows = pageResult.getRows();
        if (CollectionUtils.isNotEmpty(rows)) {
            for (int i = 0; i < rows.size(); i++) {
                StrategyAnalyzeBillDto dto = modelMapper.map(rows.get(i), StrategyAnalyzeBillDto.class);
//                ResultData<SysUserDto> employee = sysUserApi.findByEmployeeCode(rows.get(i).getCode());
//                dto.setCreatorPosition(employee.getData().getSpName());
                dto.setCreatorPosition("齐天大圣");
                newRows.add(dto);
            }
            newPageResult.setRows(newRows);
            newPageResult.setTotal(pageResult.getTotal());
            newPageResult.setPage(pageResult.getPage());
        }
        return ResultData.success(newPageResult);
    }

    @Override
    public ResultData<StrategyAnalyzeBillDto> update(StrategyAnalyzeBillDto strategyAnalyzeBill) {
        if (strategyAnalyzeBill != null) {
            StrategyAnalyzeBill strategyAnalyzeBill1 = modelMapper.map(strategyAnalyzeBill, StrategyAnalyzeBill.class);
            return ResultData.success(modelMapper.map(service.update(strategyAnalyzeBill1), StrategyAnalyzeBillDto.class));
        }
        return ResultData.fail("参数为空");


    }

    @Override
    public ResultData<List<StrategyAnalyzeBillDto>> export(Search search) {
        List<StrategyAnalyzeBillDto> newRows = new ArrayList<>();
        List<StrategyAnalyzeBill> pageResult = service.findByFilters(search);
        if (CollectionUtils.isNotEmpty(pageResult)) {
            pageResult.forEach(x -> newRows.add(modelMapper.map(x, StrategyAnalyzeBillDto.class)));
        }
        return ResultData.success(newRows);
    }

    @Override
    public ResultData<String> uploadStrategyAnalyzeBill(List<StrategyAnalyzeBillDto> strategyAnalyzeBills) {
        if (CollectionUtils.isNotEmpty(strategyAnalyzeBills)) {
            List<StrategyAnalyzeBill> strategyAnalyzeBillList = new ArrayList<>();
            for (int i = 0; i < strategyAnalyzeBills.size(); i++) {
                StrategyAnalyzeBill map = modelMapper.map(strategyAnalyzeBills.get(i), StrategyAnalyzeBill.class);
                map.setState("0");
                map.setCode(serialService.getNumber(StrategyAnalyzeBill.class));
                strategyAnalyzeBillList.add(map);
            }
            service.uploadStrategyAnalyzeBill(strategyAnalyzeBillList);
        }
        return ResultData.success();
    }
}
