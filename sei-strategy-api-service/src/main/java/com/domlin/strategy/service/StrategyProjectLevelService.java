package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectLevelDao;
import com.domlin.strategy.entity.StrategyProjectLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目分级(StrategyProjectLevel)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:19
 */
@Service
public class StrategyProjectLevelService extends BaseEntityService<StrategyProjectLevel> {
    @Autowired
    private StrategyProjectLevelDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectLevel> getDao() {
        return dao;
    }

}
