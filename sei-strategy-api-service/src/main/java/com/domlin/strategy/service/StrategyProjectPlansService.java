package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectPlansDao;
import com.domlin.strategy.dto.StrategyProjectDto;
import com.domlin.strategy.dto.StrategyProjectPlansDto;
import com.domlin.strategy.entity.StrategyProjectPlans;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 行动计划表单(StrategyProjectPlans)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:23
 */
@Service
public class StrategyProjectPlansService extends BaseEntityService<StrategyProjectPlans> {
    @Autowired
    private StrategyProjectPlansDao dao;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected BaseEntityDao<StrategyProjectPlans> getDao() {
        return dao;
    }

    public List<StrategyProjectPlans> findByStrategyProjectId(String projectId) {
        return dao.findByProjectId(projectId);
    }

    /**
     * 保存行动计划
     *
     * @param strategyProject
     */
    public void save(StrategyProjectDto strategyProject) {
        dao.deleteByProjectId(strategyProject.getId());
        List<StrategyProjectPlansDto> strategyProjectPlans = strategyProject.getPlans();
        if (strategyProjectPlans != null && strategyProjectPlans.size() > 0) {
            for (StrategyProjectPlansDto strategyProjectPlan : strategyProjectPlans) {
                StrategyProjectPlans strategyProjectPlans1 = modelMapper.map(strategyProjectPlan, StrategyProjectPlans.class);
                strategyProjectPlans1.setProjectId(strategyProject.getId());
                dao.save(strategyProjectPlans1);
            }
        }

    }
}
