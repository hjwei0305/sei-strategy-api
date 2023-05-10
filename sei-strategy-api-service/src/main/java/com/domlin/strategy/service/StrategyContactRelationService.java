package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyContactRelationDao;
import com.domlin.strategy.entity.StrategyContactRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 经营策略与项目联系人关联表(StrategyContactRelation)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:12:23
 */
@Service
public class StrategyContactRelationService extends BaseEntityService<StrategyContactRelation> {
    @Autowired
    private StrategyContactRelationDao dao;

    @Override
    protected BaseEntityDao<StrategyContactRelation> getDao() {
        return dao;
    }

}
