package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectOfficerRelationDao;
import com.domlin.strategy.entity.StrategyProjectOfficerRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目负责人关联表(StrategyProjectOfficerRelation)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:22
 */
@Service
public class StrategyProjectOfficerRelationService extends BaseEntityService<StrategyProjectOfficerRelation> {
    @Autowired
    private StrategyProjectOfficerRelationDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectOfficerRelation> getDao() {
        return dao;
    }

}
