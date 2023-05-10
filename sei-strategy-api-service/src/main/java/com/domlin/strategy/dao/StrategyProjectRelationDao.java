package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyProjectRelation;
import org.springframework.stereotype.Repository;

/**
 * 经营策略与项目关联表(StrategyProjectRelation)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:13:24
 */
@Repository
public interface StrategyProjectRelationDao extends BaseEntityDao<StrategyProjectRelation> {

}
