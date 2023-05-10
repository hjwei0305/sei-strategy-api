package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyRelatedRelationDao;
import com.domlin.strategy.entity.StrategyRelatedRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目相关人员关联表(StrategyRelatedRelation)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:30
 */
@Service
public class StrategyRelatedRelationService extends BaseEntityService<StrategyRelatedRelation> {
    @Autowired
    private StrategyRelatedRelationDao dao;

    @Override
    protected BaseEntityDao<StrategyRelatedRelation> getDao() {
        return dao;
    }

}
