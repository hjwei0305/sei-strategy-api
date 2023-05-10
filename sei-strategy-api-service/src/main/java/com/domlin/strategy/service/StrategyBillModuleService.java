package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyBillModuleDao;
import com.domlin.strategy.entity.StrategyBillModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 经营策略模块(StrategyBillModule)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:10:14
 */
@Service
public class StrategyBillModuleService extends BaseEntityService<StrategyBillModule> {
    @Autowired
    private StrategyBillModuleDao dao;

    @Override
    protected BaseEntityDao<StrategyBillModule> getDao() {
        return dao;
    }

}
