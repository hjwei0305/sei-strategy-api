package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectChangeDetailDao;
import com.domlin.strategy.entity.StrategyProjectChangeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 人员变更明细表(StrategyProjectChangeDetail)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:12:59
 */
@Service
public class StrategyProjectChangeDetailService extends BaseEntityService<StrategyProjectChangeDetail> {
    @Autowired
    private StrategyProjectChangeDetailDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectChangeDetail> getDao() {
        return dao;
    }

}
