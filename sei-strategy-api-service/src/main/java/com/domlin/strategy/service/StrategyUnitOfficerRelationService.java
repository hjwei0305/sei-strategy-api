package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyUnitOfficerRelationDao;
import com.domlin.strategy.entity.StrategyUnitOfficerRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 经营策略与单位负责人关联表(StrategyUnitOfficerRelation)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:31
 */
@Service
public class StrategyUnitOfficerRelationService extends BaseEntityService<StrategyUnitOfficerRelation> {
    @Autowired
    private StrategyUnitOfficerRelationDao dao;

    @Override
    protected BaseEntityDao<StrategyUnitOfficerRelation> getDao() {
        return dao;
    }

}
