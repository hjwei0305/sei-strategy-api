package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyPlansFilesDao;
import com.domlin.strategy.entity.StrategyPlansFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目与文件关联表(StrategyPlansFiles)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:12:43
 */
@Service
public class StrategyPlansFilesService extends BaseEntityService<StrategyPlansFiles> {
    @Autowired
    private StrategyPlansFilesDao dao;

    @Override
    protected BaseEntityDao<StrategyPlansFiles> getDao() {
        return dao;
    }

}
