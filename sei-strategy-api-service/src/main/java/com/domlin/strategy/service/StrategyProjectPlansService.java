package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectPlansDao;
import com.domlin.strategy.entity.StrategyProjectPlans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    @Override
    protected BaseEntityDao<StrategyProjectPlans> getDao() {
        return dao;
    }

}
