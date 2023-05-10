package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectVerifyDao;
import com.domlin.strategy.entity.StrategyProjectVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 验证问题(StrategyProjectVerify)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:28
 */
@Service
public class StrategyProjectVerifyService extends BaseEntityService<StrategyProjectVerify> {
    @Autowired
    private StrategyProjectVerifyDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectVerify> getDao() {
        return dao;
    }

}
