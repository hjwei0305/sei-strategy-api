package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyModuleRelation;
import org.springframework.stereotype.Repository;

/**
 * 经营策略与模块负责人关联表(StrategyModuleRelation)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:12:35
 */
@Repository
public interface StrategyModuleRelationDao extends BaseEntityDao<StrategyModuleRelation> {

}
