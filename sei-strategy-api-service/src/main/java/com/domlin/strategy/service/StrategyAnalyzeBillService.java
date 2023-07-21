package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.serial.sdk.SerialService;
import com.domlin.strategy.dao.StrategyAnalyzeBillDao;
import com.domlin.strategy.entity.StrategyAnalyzeBill;
import com.domlin.strategy.entity.StrategyUser;
import com.domlin.strategy.vo.StrategyAnalyzeBillDto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 经营策略(StrategyAnalyzeBill)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:09:57
 */
@Service
public class StrategyAnalyzeBillService extends BaseEntityService<StrategyAnalyzeBill> {
    @Autowired
    private StrategyAnalyzeBillDao dao;

    @Override
    protected BaseEntityDao<StrategyAnalyzeBill> getDao() {
        return dao;
    }

    @Autowired(required = false)
    private SerialService serialService;

    @Autowired(required = false)
    private StrategyUserService strategyUserService;

    @Override
    @Transactional
    public OperateResultWithData<StrategyAnalyzeBill> save(StrategyAnalyzeBill entity) {
        if (StringUtils.isBlank(entity.getCode())) {
            entity.setCode(serialService.getNumber(StrategyAnalyzeBill.class));
        }
        return super.save(entity);
    }

    public StrategyAnalyzeBill update(StrategyAnalyzeBill strategyAnalyzeBill) {
        return dao.save(strategyAnalyzeBill);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultData<String> uploadStrategyAnalyzeBill(List<StrategyAnalyzeBill> strategyAnalyzeBill) {
        if (CollectionUtils.isNotEmpty(strategyAnalyzeBill)) {
            save(strategyAnalyzeBill);
        } else {
            throw new RuntimeException("导入数据不能为空");
        }
        return ResultData.success("导入成功");
    }

    public StrategyAnalyzeBill findByProjectId(String pojectId){
        return dao.findByProjectId(pojectId);
    }

    public void getManagements(StrategyAnalyzeBillDto dto) {
        if (dto != null) {
            List<StrategyUser> strategyUsers = strategyUserService.findManagementsByModuleCode(dto.getModuleCode());
            if (CollectionUtils.isNotEmpty(strategyUsers)) {
                String managementCodes = "";
                String managementNames = "";
                String managemetDepartments = "";
                for (int i = 0; i < strategyUsers.size(); i++) {
                    managementCodes += strategyUsers.get(i).getUserCode() + ",";
                    managementNames += strategyUsers.get(i).getUserName() + ",";
                    managemetDepartments += strategyUsers.get(i).getDepartment() + ",";
                }
                dto.setManagemetCodes(managementCodes);
                dto.setManagemetNames(managementNames);
                dto.setManagemetDepartments(managemetDepartments);
            }
        }
    }
}
