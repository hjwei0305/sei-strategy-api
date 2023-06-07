package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectDao;
import com.domlin.strategy.entity.StrategyProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目(StrategyProject)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:12:49
 */
@Service
public class StrategyProjectService extends BaseEntityService<StrategyProject> {
    @Autowired
    private StrategyProjectDao dao;

    @Override
    protected BaseEntityDao<StrategyProject> getDao() {
        return dao;
    }

    public void update(StrategyProject entity) {
        dao.save(entity);
    }
}
