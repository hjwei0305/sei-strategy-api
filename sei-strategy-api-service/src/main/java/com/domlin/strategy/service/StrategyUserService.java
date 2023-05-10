package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyUserDao;
import com.domlin.strategy.entity.StrategyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 人员信息(StrategyUser)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:33
 */
@Service
public class StrategyUserService extends BaseEntityService<StrategyUser> {
    @Autowired
    private StrategyUserDao dao;

    @Override
    protected BaseEntityDao<StrategyUser> getDao() {
        return dao;
    }

}
