package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectModuleRelationDao;
import com.domlin.strategy.entity.StrategyProjectModuleRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目与模块关联表(StrategyProjectModuleRelation)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:20
 */
@Service
public class StrategyProjectModuleRelationService extends BaseEntityService<StrategyProjectModuleRelation> {
    @Autowired
    private StrategyProjectModuleRelationDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectModuleRelation> getDao() {
        return dao;
    }

}
