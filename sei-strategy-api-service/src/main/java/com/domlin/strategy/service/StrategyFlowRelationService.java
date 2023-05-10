package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyFlowRelationDao;
import com.domlin.strategy.entity.StrategyFlowRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目与流程关联表(StrategyFlowRelation)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:12:31
 */
@Service
public class StrategyFlowRelationService extends BaseEntityService<StrategyFlowRelation> {
    @Autowired
    private StrategyFlowRelationDao dao;

    @Override
    protected BaseEntityDao<StrategyFlowRelation> getDao() {
        return dao;
    }

}
