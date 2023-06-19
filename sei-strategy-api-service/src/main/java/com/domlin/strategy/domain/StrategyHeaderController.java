package com.domlin.strategy.domain;

import com.changhong.sei.basic.api.SysUserApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.serial.sdk.SerialService;
import com.domlin.strategy.api.StrategyHeaderApi;
import com.domlin.strategy.constant.StrategyConstant;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                //经营策略
                StrategyAnalyzeBillDto strategyAnalyzeBillDto = modelMapper.map(strategyAnalyzeBill, StrategyAnalyzeBillDto.class);
                //项目实体
                List<StrategyProject> StrategyProjectList = strategyProjectService.findByStrategyAnalyzeBillId(strategyAnalyzeBill.getId());
                //如果有项目，返回封装后的项目
                if (CollectionUtils.isNotEmpty(StrategyProjectList)) {
                    //项目dto
                    List<StrategyProjectDto> strategyProjectDtoList = new ArrayList<>();
                    for (StrategyProject strategyProject : StrategyProjectList) {
                        //拷贝一份经营策略，多个项目要展示多次
                        StrategyAnalyzeBillDto newDto = new StrategyAnalyzeBillDto();
                        BeanUtils.copyProperties(strategyAnalyzeBillDto, newDto);
                        StrategyProjectDto projectDto = modelMapper.map(strategyProject, StrategyProjectDto.class);
                        strategyProjectDtoList.add(projectDto);
                        //处理关联关系
                        newDto.setProjectDtoList(strategyProjectDtoList);
                        //返回临时类
                        StrategyHeaderDto temp = new StrategyHeaderDto();
                        temp.setId(strategyAnalyzeBill.getId()+strategyProject.getId());
                        temp.setStrategyAnalyzeBillDto(newDto);
                        temp.setStrategyProjectDto(projectDto);
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
    public ResultData<StrategyHeaderDto> save(StrategyHeaderDto strategyHeaderDto) {
        if (strategyHeaderDto == null) {
            return ResultData.fail("参数为空");
        }
        //所有经营策略
        StrategyAnalyzeBillDto strategyAnalyzeBillDto = strategyHeaderDto.getStrategyAnalyzeBillDto();
        //更新经营策略
        if (strategyAnalyzeBillDto != null) {
            //所有项目
            List<StrategyProjectDto> strategyProjectDtoList = strategyAnalyzeBillDto.getProjectDtoList();
            //所有经营策略编码
            List<Map<String, String>> strategyCodes = strategyHeaderDto.getStrategyCodes();

            String projectId = null;

            //新增项目
            if (CollectionUtils.isNotEmpty(strategyProjectDtoList)) {
                for (StrategyProjectDto strategyProjectDto : strategyProjectDtoList) {
                    StrategyProject map = modelMapper.map(strategyProjectDto, StrategyProject.class);
                    map.setCode(serialService.getNumber("strategyProject"));
                    OperateResultWithData<StrategyProject> save = strategyProjectService.save(modelMapper.map(strategyProjectDto, StrategyProject.class));
                    projectId = save.getData().getId();
                    //单个经营策略与项目关联关系，如果存在多经营策略，就会在下面一段逻辑更新。
                    if (CollectionUtils.isEmpty(strategyCodes)|| strategyCodes.size()==0) {
                        strategyProjectService.saveStrategyProjectRelation(strategyAnalyzeBillDto.getId(), projectId);
                        updateStage(strategyAnalyzeBillDto.getId(), StrategyConstant.STAGE_SUBIMIT);
                    }
                }
            }

            //更新经营策略与项目的关系，多个经营策略，一个项目
            if (CollectionUtils.isNotEmpty(strategyCodes)&& strategyCodes.size()>0) {
                strategyProjectService.saveStrategyProjectRelation(strategyAnalyzeBillDto.getId(), projectId);
                updateStage(strategyAnalyzeBillDto.getId(), StrategyConstant.STAGE_SUBIMIT);
                for (Map<String, String> strategyCode : strategyCodes) {
                    //经营策略id
                    String id = strategyCode.get("id");
                    //新增经营策略与项目关联关系
                    strategyProjectService.saveStrategyProjectRelation(id, projectId);
                    //通过经营策略id，更新经营策略stage
                    updateStage(id, StrategyConstant.STAGE_SUBIMIT);
                }
            }
        }
        return ResultData.success();
    }


    //更新经营策略阶段
    public void updateStage(String id, String stage) {
        StrategyAnalyzeBill strategyAnalyzeBill = service.findOne(id);
        strategyAnalyzeBill.setStage(stage);
        service.update(strategyAnalyzeBill);
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
