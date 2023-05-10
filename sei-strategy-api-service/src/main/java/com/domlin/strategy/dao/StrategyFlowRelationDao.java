package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyFlowRelation;
import org.springframework.stereotype.Repository;

/**
 * 项目与流程关联表(StrategyFlowRelation)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:12:30
 */
@Repository
public interface StrategyFlowRelationDao extends BaseEntityDao<StrategyFlowRelation> {

}
