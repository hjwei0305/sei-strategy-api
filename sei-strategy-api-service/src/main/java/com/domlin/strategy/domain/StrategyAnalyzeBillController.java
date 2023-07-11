package com.domlin.strategy.domain;


import com.changhong.sei.core.controller.BaseEntityController;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.dto.serach.PageResult;
import com.changhong.sei.core.dto.serach.Search;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.serial.sdk.SerialService;
import com.domlin.strategy.api.StrategyAnalyzeBillApi;
import com.domlin.strategy.dto.StrategyUserDto;
import com.domlin.strategy.entity.StrategyProject;
import com.domlin.strategy.entity.StrategyUser;
import com.domlin.strategy.service.StrategyUserService;
import com.domlin.strategy.vo.StrategyAnalyzeBillDto;
import com.domlin.strategy.entity.StrategyAnalyzeBill;
import com.domlin.strategy.service.StrategyAnalyzeBillService;
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

    @Autowired
    private StrategyProjectService strategyProjectService;

    @Override
    public BaseEntityService<StrategyAnalyzeBill> getService() {
        return service;
    }

    @Autowired
    private ModelMapper modelMapper;

    @Autowired(required = false)
    private SerialService serialService;

    @Autowired(required = false)
    private StrategyUserService strategyUserService;


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
                // 项目负责人
                getOfficer(dto);
                // 模块对接人
                getContact(dto);
                // 管理者成员
                getManagements(dto);
                newRows.add(dto);
            }
            newPageResult.setRows(newRows);
            newPageResult.setTotal(pageResult.getTotal());
            newPageResult.setPage(pageResult.getPage());
        }
        return ResultData.success(newPageResult);
    }

    private void getManagements(StrategyAnalyzeBillDto dto) {
        if (dto != null) {
            List<StrategyUser> strategyUsers = strategyUserService.findManagementsByModuleCode(dto.getModuleCode());
            if (CollectionUtils.isNotEmpty(strategyUsers)) {
                String managementCodes = "";
                String managementNames = "";

                for (int i = 0; i < strategyUsers.size(); i++) {
                    managementCodes += strategyUsers.get(i).getUserCode() + ",";
                    managementNames += strategyUsers.get(i).getUserName() + ",";
                }
                dto.setManagemetCodes(managementCodes);
                dto.setManagemetNames(managementNames);
            }
        }
    }

    private void getContact(StrategyAnalyzeBillDto dto) {
        if (dto != null) {
            // 通过moduleCode查出对应的模块对接人
            List<StrategyUser> contacts = strategyUserService.findContactByModuleCode(dto.getModuleCode());
            List<StrategyUserDto> strategyUserDtos = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(contacts)) {
                for (StrategyUser strategyUser : contacts) {
                    StrategyUserDto strategyUserDto = modelMapper.map(strategyUser, StrategyUserDto.class);
                    strategyUserDtos.add(strategyUserDto);
                }
            }
            dto.setContacts(strategyUserDtos);
        }
    }

    private void getOfficer(StrategyAnalyzeBillDto dto) {

        if (dto != null) {
            // 通过经营策略id获取StrategyProjectDto
            List<StrategyProject> StrategyProjectList = strategyProjectService.findByStrategyAnalyzeBillId(dto.getId());
            if (CollectionUtils.isNotEmpty(StrategyProjectList)) {
                String officerCodes = "";
                String officerNames = "";
                String officePosition = "";
                for (StrategyProject strategyProject : StrategyProjectList) {
                    if (strategyProject != null) {
                        List<StrategyUser> officers = strategyUserService.findOfficerByProjectId(strategyProject.getId());
                        if (CollectionUtils.isNotEmpty(officers)) {
                            for (StrategyUser strategyUser : officers) {
                                StrategyUserDto strategyUserDto = modelMapper.map(strategyUser, StrategyUserDto.class);
                                officerCodes += strategyUserDto.getUserCode() + ",";
                                officerNames += strategyUserDto.getUserName() + ",";
                                officePosition += strategyUserDto.getPosition() + ",";
                            }
                        }
                    }
                }
                dto.setOfficerCodes(officerCodes);
                dto.setOfficerNames(officerNames);
                dto.setOfficerPositions(officePosition);
            }
        }
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
