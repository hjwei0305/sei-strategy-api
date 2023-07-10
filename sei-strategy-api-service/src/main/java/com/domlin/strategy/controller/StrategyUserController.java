package com.domlin.strategy.controller;

import com.changhong.sei.basic.api.SysUserApi;
import com.changhong.sei.basic.dto.SysUserDto;
import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.domlin.strategy.api.StrategyUserApi;
import com.domlin.strategy.dto.StrategyUserDto;
import com.domlin.strategy.entity.StrategyUser;
import com.domlin.strategy.service.StrategyUserService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 人员信息(StrategyUser)控制类
 *
 * @author sei
 * @since 2023-05-09 15:13:33
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyUserApi", tags = "人员信息服务")
@RequestMapping(path = StrategyUserApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyUserController extends BaseEntityController<StrategyUser, StrategyUserDto> implements StrategyUserApi {
    /**
     * 人员信息服务对象
     */
    @Autowired
    private StrategyUserService service;

    @Autowired
    private SysUserApi sysUserApi;

    @Override
    public BaseEntityService<StrategyUser> getService() {
        return service;
    }
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResultData<PageResult<StrategyUserDto>> findByPage(Search search) {
        return convertToDtoPageResult(service.findByPage(search));
    }

    @Override
    public ResultData<StrategyUserDto> update(StrategyUserDto strategyUser) {
        if (strategyUser != null){
            StrategyUser update = service.update(modelMapper.map(strategyUser, StrategyUser.class));
            return ResultData.success(modelMapper.map(update,StrategyUserDto.class));
        }
        return ResultData.fail("参数为空");
    }

    @Override
    public ResultData<List<StrategyUserDto>> export(Search search) {
        List<StrategyUser> export = service.findByFilters(search);
        List<StrategyUserDto> newRow = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(export)){
            export.forEach(x -> newRow.add(modelMapper.map(x,StrategyUserDto.class)));
        }
        return ResultData.success(newRow);
    }

    @Override
    public ResultData<String> uploadStrategyUser(List<StrategyUserDto> list) {
        List<StrategyUser> newRow = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(list)){
            list.forEach(x -> newRow.add(modelMapper.map(x,StrategyUser.class)));
        }
        String s = service.uploadStrategyUser(newRow);
        return ResultData.success(s);
    }

    /**
     * 保存人员信息
     * @param strategyUserDto
     * @return
     */
    @Override
    public ResultData<StrategyUserDto> save(@RequestBody StrategyUserDto strategyUserDto){
        if (strategyUserDto != null){
            ResultData<SysUserDto> byEmployeeCode = sysUserApi.findByEmployeeCode(strategyUserDto.getUserCode());
            if (byEmployeeCode.getData() != null){
                strategyUserDto.setPosition(byEmployeeCode.getData().getSpName());
            }
            OperateResultWithData<StrategyUser> save = service.save(modelMapper.map(strategyUserDto, StrategyUser.class));
            return ResultData.success(modelMapper.map(save,StrategyUserDto.class));
        }
        return ResultData.fail("参数为空");
    }
}
