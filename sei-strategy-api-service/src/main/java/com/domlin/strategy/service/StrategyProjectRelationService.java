package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectRelationDao;
import com.domlin.strategy.entity.StrategyProjectRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 经营策略与项目关联表(StrategyProjectRelation)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:24
 */
@Service
public class StrategyProjectRelationService extends BaseEntityService<StrategyProjectRelation> {
    @Autowired
    private StrategyProjectRelationDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectRelation> getDao() {
        return dao;
    }

}
