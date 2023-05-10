package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyModuleRelationDao;
import com.domlin.strategy.entity.StrategyModuleRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 经营策略与模块负责人关联表(StrategyModuleRelation)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:12:35
 */
@Service
public class StrategyModuleRelationService extends BaseEntityService<StrategyModuleRelation> {
    @Autowired
    private StrategyModuleRelationDao dao;

    @Override
    protected BaseEntityDao<StrategyModuleRelation> getDao() {
        return dao;
    }

}
