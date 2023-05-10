package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyUser;
import org.springframework.stereotype.Repository;

/**
 * 人员信息(StrategyUser)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:13:33
 */
@Repository
public interface StrategyUserDao extends BaseEntityDao<StrategyUser> {

}
