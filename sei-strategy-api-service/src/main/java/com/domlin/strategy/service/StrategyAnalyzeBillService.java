package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyAnalyzeBillDao;
import com.domlin.strategy.entity.StrategyAnalyzeBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

}
