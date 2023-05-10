package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectStyleDao;
import com.domlin.strategy.entity.StrategyProjectStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 项目类别(StrategyProjectStyle)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:13:27
 */
@Service
public class StrategyProjectStyleService extends BaseEntityService<StrategyProjectStyle> {
    @Autowired
    private StrategyProjectStyleDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectStyle> getDao() {
        return dao;
    }

}
