package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectFilesDao;
import com.domlin.strategy.entity.StrategyProjectFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目与文件关联表(StrategyProjectFiles)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:10
 */
@Service
public class StrategyProjectFilesService extends BaseEntityService<StrategyProjectFiles> {
    @Autowired
    private StrategyProjectFilesDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectFiles> getDao() {
        return dao;
    }

}
