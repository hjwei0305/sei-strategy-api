package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.serial.sdk.SerialService;
import com.domlin.strategy.dao.StrategyProjectDao;
import com.domlin.strategy.dao.StrategyProjectRelationDao;
import com.domlin.strategy.dto.StrategyProjectDto;
import com.domlin.strategy.entity.StrategyProject;
import com.domlin.strategy.entity.StrategyProjectRelation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Autowired
    private StrategyProjectRelationDao strategyProjectRelationDao;

    @Autowired(required = false)
    private SerialService serialService;

    @Override
    @Transactional
    public OperateResultWithData<StrategyProject> save(StrategyProject entity) {
        if (StringUtils.isBlank(entity.getCode())) {
            entity.setCode(serialService.getNumber(StrategyProject.class));
        }
        return super.save(entity);
    }


    public void update(StrategyProject entity) {
        dao.save(entity);
    }

    public List<StrategyProject> findByStrategyAnalyzeBillId(String id) {
        return dao.findByStrategyAnalyzeBillId(id);
    }

    public void saveStrategyProjectRelation(String id, String id1) {
        StrategyProjectRelation strategyProjectRelation = new StrategyProjectRelation();
        strategyProjectRelation.setStrategyId(id);
        strategyProjectRelation.setProjectId(id1);
        strategyProjectRelationDao.save(strategyProjectRelation);
    }
}
