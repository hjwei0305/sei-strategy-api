package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyUserDao;
import com.domlin.strategy.dto.StrategyUserDto;
import com.domlin.strategy.entity.StrategyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    public StrategyUser update(StrategyUser strategyUser) {
        return dao.save(strategyUser);
    }

    @Transactional(rollbackFor = Exception.class)
    public String uploadStrategyUser(List<StrategyUser> newRow) {
        if (newRow != null && newRow.size() > 0) {
            save(newRow);
        } else {
            throw new RuntimeException("导入数据不能为空");
        }
        return "导入成功";
    }

    public List<StrategyUser> findByModuleCode(String moduleCode) {
        return dao.findByModuleCode(moduleCode);
    }
}
