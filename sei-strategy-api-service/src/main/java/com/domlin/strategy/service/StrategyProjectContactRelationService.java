package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectContactRelationDao;
import com.domlin.strategy.entity.StrategyProjectContactRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目对接人员关联表(StrategyProjectContactRelation)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:08
 */
@Service
public class StrategyProjectContactRelationService extends BaseEntityService<StrategyProjectContactRelation> {
    @Autowired
    private StrategyProjectContactRelationDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectContactRelation> getDao() {
        return dao;
    }

}
