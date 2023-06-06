package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyAnalyzeBillDao;
import com.domlin.strategy.entity.StrategyAnalyzeBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 经营策略(StrategyAnalyzeBill)业务逻辑实现类
 *
 * @author sei
 * @since 2023-05-09 15:09:57
 */
@Service
public class StrategyAnalyzeBillService extends BaseEntityService<StrategyAnalyzeBill> {
    @Autowired
    private StrategyAnalyzeBillDao dao;

    @Override
    protected BaseEntityDao<StrategyAnalyzeBill> getDao() {
        return dao;
    }

    public StrategyAnalyzeBill update(StrategyAnalyzeBill strategyAnalyzeBill) {
        return dao.save(strategyAnalyzeBill);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultData<String> uploadStrategyAnalyzeBill(StrategyAnalyzeBill strategyAnalyzeBill) {
        if (strategyAnalyzeBill != null) {
            save(strategyAnalyzeBill);
        } else {
            throw new RuntimeException("导入数据不能为空");
        }
        return ResultData.success("导入成功");
    }
}
