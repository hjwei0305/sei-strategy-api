package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectChangeDao;
import com.domlin.strategy.entity.StrategyProjectChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目变更表(StrategyProjectChange)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:12:52
 */
@Service
public class StrategyProjectChangeService extends BaseEntityService<StrategyProjectChange> {
    @Autowired
    private StrategyProjectChangeDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectChange> getDao() {
        return dao;
    }

}
