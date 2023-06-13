package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyProject;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目(StrategyProject)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:12:48
 */
@Repository
public interface StrategyProjectDao extends BaseEntityDao<StrategyProject> {
    /**
     * 通过Strategy的id查找StrategyProject，关联表strategy_project_relation中strategyId为Strategy的id，project_id为StrategyProject的id
     * @param id
     * @return
     */
    @Modifying
    @Query("select sp from StrategyProject sp,StrategyProjectRelation spr where spr.strategyId = :id and spr.projectId = sp.id")
    List<StrategyProject> findByStrategyAnalyzeBillId(String id);
}
