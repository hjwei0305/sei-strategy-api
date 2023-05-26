package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectVerifyDao;
import com.domlin.strategy.entity.StrategyProjectVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    public StrategyProjectVerify update(StrategyProjectVerify strategyProjectVerify) {
            return dao.save(strategyProjectVerify);
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultData<String> uploadStrategyProjectVerify(List<StrategyProjectVerify> collect) {
        if (collect != null && collect.size() > 0) {
            save(collect);
        } else {
            throw new RuntimeException("导入数据不能为空");
        }
        return ResultData.success("导入成功");
    }
}
