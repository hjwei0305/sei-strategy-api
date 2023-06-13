package com.domlin.strategy.controller;

import com.changhong.sei.basic.api.SysUserApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.serial.sdk.SerialService;
import com.domlin.strategy.api.StrategyHeaderApi;
import com.domlin.strategy.dto.StrategyAnalyzeBillDto;
import com.domlin.strategy.dto.StrategyHeaderDto;
import com.domlin.strategy.dto.StrategyProjectDto;
import com.domlin.strategy.entity.StrategyAnalyzeBill;
import com.domlin.strategy.entity.StrategyProject;
import com.domlin.strategy.service.StrategyAnalyzeBillService;
import com.domlin.strategy.service.StrategyProjectService;
import io.swagger.annotations.Api;
import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 经营策略(StrategyAnalyzeBill)控制类
 *
 * @author wake
 * @since 2023-05-09 15:09:58
 */
@RestController
@Api(value = "com.domlin.strategy.api.StrategyAnalyzeBillApi", tags = "经营策略服务")
@RequestMapping(path = StrategyHeaderApi.PATH, produces = MediaType.APPLICATION_JSON_VALUE)
public class StrategyHeaderController implements StrategyHeaderApi {
    /**
     * 经营策略服务对象
     */
    @Autowired
    private StrategyAnalyzeBillService service;

    @Autowired
    private StrategyProjectService strategyProjectService;


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SysUserApi sysUserApi;

    @Autowired(required = false)
    private SerialService serialService;

    @Override
    public ResultData<PageResult<StrategyHeaderDto>> findByPage(Search search) {
        //返回包装类
        PageResult<StrategyHeaderDto> newPageResult = new PageResult<>();
        //返回的经营策略
        List<StrategyHeaderDto> strategyHeaderDtoList = new ArrayList<>();
        //查询所有经营策略
        PageResult<StrategyAnalyzeBill> pageResult = service.findByPage(search);
        List<StrategyAnalyzeBill> strategyAnalyzeBillList = pageResult.getRows();

        //组装返回集合
        if (CollectionUtils.isNotEmpty(strategyAnalyzeBillList)) {
            for (StrategyAnalyzeBill strategyAnalyzeBill : strategyAnalyzeBillList) {

                StrategyAnalyzeBillDto strategyAnalyzeBillDto = modelMapper.map(strategyAnalyzeBill, StrategyAnalyzeBillDto.class);
                //通过经营策略查找项目
                List<StrategyProject> StrategyProjectList = strategyProjectService.findByStrategyAnalyzeBillId(strategyAnalyzeBill.getId());
                if (CollectionUtils.isNotEmpty(StrategyProjectList)) {
                    //如果有项目，返回封装后的项目
                    for (StrategyProject strategyProject : StrategyProjectList) {
                        //拷贝一份经营策略，多个项目要展示多次
                        StrategyAnalyzeBillDto newDto = new StrategyAnalyzeBillDto();
                        BeanUtils.copyProperties(strategyAnalyzeBillDto, newDto);
                        StrategyProjectDto strategyProjectDto = modelMapper.map(strategyProject, StrategyProjectDto.class);
                        newDto.setStrategyProjectDto(strategyProjectDto);
                        //返回临时类
                        StrategyHeaderDto temp = new StrategyHeaderDto();
                        temp.setId(strategyAnalyzeBill.getId());
                        temp.setStrategyAnalyzeBillDto(newDto);
                        strategyHeaderDtoList.add(temp);
                    }
                }else {
                    //没有项目，只返回经营策略
                    //返回临时类
                    StrategyHeaderDto temp = new StrategyHeaderDto();
                    temp.setId(strategyAnalyzeBill.getId());
                    temp.setStrategyAnalyzeBillDto(strategyAnalyzeBillDto);
                    strategyHeaderDtoList.add(temp);
                }
            }
        }
        newPageResult.setRows(strategyHeaderDtoList);
        newPageResult.setTotal(pageResult.getTotal());
        return ResultData.success(newPageResult);
    }

    @Override
    public ResultData<StrategyHeaderDto> updateStrategyAnalyzeBillAndProject(StrategyHeaderDto strategyHeaderDto) {
        if (strategyHeaderDto == null) {
            return ResultData.fail("参数为空");
           }
        //所有经营策略
        StrategyAnalyzeBillDto strategyAnalyzeBillDto = strategyHeaderDto.getStrategyAnalyzeBillDto();
        //更新经营策略
        if (strategyAnalyzeBillDto != null) {
            service.save(modelMapper.map(strategyAnalyzeBillDto,StrategyAnalyzeBill.class));
            //所有项目
            List<StrategyProjectDto> strategyProjectDtoList = strategyAnalyzeBillDto.getSaveProjects();
            //更新项目
            if (CollectionUtils.isNotEmpty(strategyProjectDtoList)) {
                for (StrategyProjectDto strategyProjectDto : strategyProjectDtoList) {
                    StrategyProject map = modelMapper.map(strategyProjectDto, StrategyProject.class);
                    map.setCode(serialService.getNumber("strategyProject"));
                    strategyProjectService.save(modelMapper.map(strategyProjectDto, StrategyProject.class));
                }
            }
        }
        return ResultData.success();
    }

    @Override
    public ResultData<StrategyHeaderDto> save(@Valid StrategyHeaderDto dto) {
        return null;
    }

    @Override
    public ResultData<?> delete(String id) {
        return null;
    }

    @Override
    public ResultData<StrategyHeaderDto> findOne(String id) {
        return null;
    }
}
