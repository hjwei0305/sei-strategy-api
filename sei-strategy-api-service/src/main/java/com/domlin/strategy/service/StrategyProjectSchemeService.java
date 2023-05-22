package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectSchemeDao;
import com.domlin.strategy.entity.StrategyProjectScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 周期配置(StrategyProjectScheme)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:26
 */
@Service
public class StrategyProjectSchemeService extends BaseEntityService<StrategyProjectScheme> {
    @Autowired
    private StrategyProjectSchemeDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectScheme> getDao() {
        return dao;
    }

    public StrategyProjectScheme update(StrategyProjectScheme map) {
        return dao.save(map);
    }
}
