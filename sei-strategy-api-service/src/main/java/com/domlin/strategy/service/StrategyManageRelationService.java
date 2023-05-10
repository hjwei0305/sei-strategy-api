package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyManageRelationDao;
import com.domlin.strategy.entity.StrategyManageRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 经营策略与管理组关联表(StrategyManageRelation)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:12:33
 */
@Service
public class StrategyManageRelationService extends BaseEntityService<StrategyManageRelation> {
    @Autowired
    private StrategyManageRelationDao dao;

    @Override
    protected BaseEntityDao<StrategyManageRelation> getDao() {
        return dao;
    }

}
