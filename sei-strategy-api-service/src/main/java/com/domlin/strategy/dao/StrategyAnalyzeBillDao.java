package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyAnalyzeBill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 经营策略(StrategyAnalyzeBill)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:09:57
 */
@Repository
public interface StrategyAnalyzeBillDao extends BaseEntityDao<StrategyAnalyzeBill> {


    @Query("select b from StrategyAnalyzeBill b ,StrategyProjectRelation r where b.id = r.strategyId and r.projectId = :projectId")
    StrategyAnalyzeBill findByProjectId(String projectId);

}
