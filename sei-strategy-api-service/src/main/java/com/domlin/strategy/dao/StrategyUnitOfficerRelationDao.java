package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyUnitOfficerRelation;
import org.springframework.stereotype.Repository;

/**
 * 经营策略与单位负责人关联表(StrategyUnitOfficerRelation)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:13:31
 */
@Repository
public interface StrategyUnitOfficerRelationDao extends BaseEntityDao<StrategyUnitOfficerRelation> {

}
