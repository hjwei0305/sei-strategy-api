package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectLevelDao;
import com.domlin.strategy.entity.StrategyProjectLevel;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 项目分级(StrategyProjectLevel)业务逻辑实现类
 *
 * @author wake
 * @since 2023-05-09 15:13:19
 */
@Service
public class StrategyProjectLevelService extends BaseEntityService<StrategyProjectLevel> {
    @Autowired
    private StrategyProjectLevelDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectLevel> getDao() {
        return dao;
    }

    public StrategyProjectLevel update(StrategyProjectLevel map) {
        return dao.save(map);
    }

    public ResultData<String> uploadStrategyProjectLevel(List<StrategyProjectLevel> list) {
        if(CollectionUtils.isNotEmpty(list)) {
            save(list);
        } else {
            throw new RuntimeException("导入数据不能为空");
        }
        return ResultData.success("导入成功");
    }
}
