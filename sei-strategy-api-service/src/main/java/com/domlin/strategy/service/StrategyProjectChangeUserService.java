package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectChangeUserDao;
import com.domlin.strategy.entity.StrategyProjectChangeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 人员变更表(StrategyProjectChangeUser)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:06
 */
@Service
public class StrategyProjectChangeUserService extends BaseEntityService<StrategyProjectChangeUser> {
    @Autowired
    private StrategyProjectChangeUserDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectChangeUser> getDao() {
        return dao;
    }

}
