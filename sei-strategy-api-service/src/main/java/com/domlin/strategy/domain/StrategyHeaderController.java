package com.domlin.strategy.domain;

import com.changhong.sei.basic.api.SysUserApi;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.serial.sdk.SerialService;
import com.domlin.strategy.api.StrategyHeaderApi;
import com.domlin.strategy.constant.StrategyConstant;
import com.domlin.strategy.dto.*;
import com.domlin.strategy.entity.StrategyAnalyzeBill;
import com.domlin.strategy.entity.StrategyProject;
import com.domlin.strategy.entity.StrategyProjectPlans;
import com.domlin.strategy.entity.StrategyUser;
import com.domlin.strategy.service.StrategyAnalyzeBillService;
import com.domlin.strategy.service.StrategyProjectPlansService;
import com.domlin.strategy.service.StrategyProjectService;
import com.domlin.strategy.service.StrategyUserService;
import com.domlin.strategy.vo.StrategyAnalyzeBillDto;
import com.domlin.strategy.vo.StrategyHeaderDto;
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

    @Autowired
    private StrategyUserService strategyUserService;

    @Autowired(required = false)
    private SerialService serialService;

    @Autowired
    private StrategyProjectPlansService plansService;

    /**
     * 分页查询经营策略
     *
     * @param search 查询条件
     * @return 经营策略分页数据
     */
    @Override
    public ResultData<PageResult<StrategyHeaderDto>> findByPage(Search search) {

        //返回的经营策略
        List<StrategyHeaderDto> strategyHeaderDtoList = new ArrayList<>();
        //查询所有经营策略
        PageResult<StrategyAnalyzeBill> pageResult = service.findByPage(search);
        List<StrategyAnalyzeBill> strategyAnalyzeBillList = pageResult.getRows();
        //返回包装类
        PageResult<StrategyHeaderDto> newPageResult = new PageResult<>(pageResult);
        //组装返回集合
        if (CollectionUtils.isNotEmpty(strategyAnalyzeBillList)) {
            for (StrategyAnalyzeBill strategyAnalyzeBill : strategyAnalyzeBillList) {
                //经营策略
                StrategyAnalyzeBillDto strategyAnalyzeBillDto = modelMapper.map(strategyAnalyzeBill, StrategyAnalyzeBillDto.class);
                //项目实体
                List<StrategyProject> StrategyProjectList = strategyProjectService.findByStrategyAnalyzeBillId(strategyAnalyzeBill.getId());
                // 1、添加经营策略模块对接人
                List<StrategyUserDto> contacts = getContacts(strategyAnalyzeBillDto);
                // 2、添加经项目负责人
                // 3、添加项目相关方
                // 4、添加行动计划
                // 5、添加经营策略管理组
                service.getManagements(strategyAnalyzeBillDto);
                /**
                 * 这里会涉及多个Header，因为需求不合理，所以这里做了特殊处理
                 */
                if (CollectionUtils.isNotEmpty(StrategyProjectList)) {
                    for (StrategyProject strategyProject : StrategyProjectList) {
                        //拷贝一份经营策略，多个项目要展示多次
                        StrategyAnalyzeBillDto newDto = new StrategyAnalyzeBillDto();
                        BeanUtils.copyProperties(strategyAnalyzeBillDto, newDto);
                        StrategyProjectDto projectDto = modelMapper.map(strategyProject, StrategyProjectDto.class);
                        //1、添加经营策略模块对接人
                        projectDto.setContacts(contacts);
                        //2、添加经营策略项目负责人
                        getOfficers(projectDto);
                        // 3、添加项目相关方
                        getRelates(projectDto);
                        // 4、添加行动计划
                        getPlans(projectDto);
                        //返回临时类
                        StrategyHeaderDto temp = new StrategyHeaderDto();
                        temp.setId(strategyAnalyzeBill.getId()+strategyProject.getId());
                        temp.setStrategyAnalyzeBillDto(newDto);
                        temp.setStrategyProjectDto(projectDto);
                        temp.setModules(strategyAnalyzeBillDto.getModule());
                        strategyHeaderDtoList.add(temp);
                    }
                }else {
                    /**
                     * 这里只有单个Header，所以这里做了特殊处理
                     */
                    StrategyHeaderDto temp = new StrategyHeaderDto();
                    temp.setId(strategyAnalyzeBill.getId());
                    temp.setStrategyAnalyzeBillDto(strategyAnalyzeBillDto);
                    temp.setModules(strategyAnalyzeBillDto.getModule());
                    //专门处理关联项目阶段
                    StrategyProjectDto strategyProjectDto = new StrategyProjectDto();
                    strategyProjectDto.setStage(StrategyConstant.STAGE_RELEVANCY);
                    //添加经营策略模块对接人
                    strategyProjectDto.setContacts(contacts);
                    temp.setStrategyProjectDto(strategyProjectDto);
                    strategyHeaderDtoList.add(temp);
                }
            }
        }
        newPageResult.setRows(strategyHeaderDtoList);
        return ResultData.success(newPageResult);
    }

    private void getPlans(StrategyProjectDto projectDto) {
        // 通过项目id查出项目相关方
        List<StrategyProjectPlans> plans = plansService.findByStrategyProjectId(projectDto.getId());
        // 转换成dto
        List<StrategyProjectPlansDto> strategyProjectPlansDtoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(plans)) {
            for (StrategyProjectPlans strategyProjectPlans : plans) {
                StrategyProjectPlansDto strategyProjectPlansDto = modelMapper.map(strategyProjectPlans, StrategyProjectPlansDto.class);
                strategyProjectPlansDto.setIsFinancial(strategyProjectPlans.getIsFinancial());
                strategyProjectPlansDtoList.add(strategyProjectPlansDto);
            }
        }
        projectDto.setPlans(strategyProjectPlansDtoList);

    }

    public void getRelates(StrategyProjectDto projectDto) {
        // 通过项目id查出项目相关方
        List<StrategyUser> relates = strategyUserService.findByStrategyProjectId(projectDto.getId());
        // 转换成dto
        List<StrategyUserDto> strategyRelateDtoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(relates)) {
            for (StrategyUser strategyRelate : relates) {
                StrategyUserDto strategyRelateDto = modelMapper.map(strategyRelate, StrategyUserDto.class);
                strategyRelateDtoList.add(strategyRelateDto);
            }
        }
        projectDto.setRelates(strategyRelateDtoList);
    }

    /**
     * 获取经营策略模块对接人
     * @param strategyAnalyzeBillDto
     * @return
     */
    public List<StrategyUserDto> getContacts(StrategyAnalyzeBillDto strategyAnalyzeBillDto){
        // 通过moduleCode查出对应的模块对接人
        List<StrategyUser> contacts = strategyUserService.findContactByModuleCode(strategyAnalyzeBillDto.getModuleCode());
        // 转换成dto
        List<StrategyUserDto> strategyUserDtoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(contacts)) {
            for (StrategyUser strategyUser : contacts) {
                StrategyUserDto strategyUserDto = modelMapper.map(strategyUser, StrategyUserDto.class);
                strategyUserDtoList.add(strategyUserDto);
            }
        }
        return strategyUserDtoList;
    }

    /**
     * 获取经营策略项目负责人
     * @param projectDto
     * @return
     */
    public void getOfficers(StrategyProjectDto projectDto){
        // 通过经营策略id查出对应的项目负责人
        List<StrategyUser> officers = strategyUserService.findOfficerByProjectId(projectDto.getId());
        // offcerCodes
        String officerCodes = "";
        String officerNames = "";
        String officePosition = "";
        // 转换成dto
        List<StrategyUserDto> strategyUserDtoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(officers)) {
            for (StrategyUser strategyUser : officers) {
                StrategyUserDto strategyUserDto = modelMapper.map(strategyUser, StrategyUserDto.class);
                strategyUserDtoList.add(strategyUserDto);
                officerCodes += strategyUserDto.getUserCode() + ",";
                officerNames += strategyUserDto.getUserName() + ",";
                officePosition += strategyUserDto.getPosition() + ",";
            }
        }
        projectDto.setOfficers(strategyUserDtoList);
        projectDto.setOfficerCodes(officerCodes);
        projectDto.setOfficerNames(officerNames);
        projectDto.setOfficerPositions(officePosition);
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
                    strategyProjectDto.setStage(StrategyConstant.STAGE_SUBMIT);
                    OperateResultWithData<StrategyProject> save = strategyProjectService.save(modelMapper.map(strategyProjectDto, StrategyProject.class));
                    projectId = save.getData().getId();
                    //单个经营策略与项目关联关系，如果存在多经营策略，就会在下面一段逻辑更新。
                    if (CollectionUtils.isEmpty(strategyCodes)|| strategyCodes.size()==0) {
                        strategyProjectService.saveStrategyProjectRelation(strategyAnalyzeBillDto.getId(), projectId);
                        updateStage(strategyAnalyzeBillDto.getId(), StrategyConstant.STAGE_SUBMIT);
                    }
                }
            }
            //更新经营策略与项目的关系，多个经营策略，一个项目
            if (CollectionUtils.isNotEmpty(strategyCodes)&& strategyCodes.size()>0) {
                strategyProjectService.saveStrategyProjectRelation(strategyAnalyzeBillDto.getId(), projectId);
                updateStage(strategyAnalyzeBillDto.getId(), StrategyConstant.STAGE_SUBMIT);
                for (Map<String, String> strategyCode : strategyCodes) {
                    //经营策略id
                    String id = strategyCode.get("id");
                    //新增经营策略与项目关联关系
                    strategyProjectService.saveStrategyProjectRelation(id, projectId);
                    //通过经营策略id，更新经营策略stage
                    updateStage(id, StrategyConstant.STAGE_SUBMIT);
                }
            }
        }
        return ResultData.success();
    }

    /**
     * 通过projectId查询流程的经营策略
     * @param projectId
     * @return
     */
    @Override
    public ResultData<StrategyHeaderDto> findBillById(String projectId) {

        //查询所有经营策略
        StrategyAnalyzeBill bill = service.findByProjectId(projectId);
        StrategyProject one = strategyProjectService.findOne(projectId);

        StrategyAnalyzeBillDto strategyAnalyzeBillDto = modelMapper.map(bill, StrategyAnalyzeBillDto.class);
        List<StrategyUserDto> contacts = getContacts(strategyAnalyzeBillDto);
        service.getManagements(strategyAnalyzeBillDto);

        StrategyProjectDto projectDto = modelMapper.map(one, StrategyProjectDto.class);
        //1、添加经营策略模块对接人
        projectDto.setContacts(contacts);
        //2、添加经营策略项目负责人
        getOfficers(projectDto);
        // 3、添加项目相关方
        getRelates(projectDto);
        // 4、添加行动计划
        getPlans(projectDto);

        //返回临时类
        StrategyHeaderDto temp = new StrategyHeaderDto();
        temp.setId(one.getId());
        temp.setStrategyAnalyzeBillDto(strategyAnalyzeBillDto);
        temp.setStrategyProjectDto(projectDto);
        temp.setModules(strategyAnalyzeBillDto.getModule());
        return ResultData.success(temp);
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
