package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyProjectPlans;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

/**
 * 行动计划表单(StrategyProjectPlans)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:13:23
 */
@Repository
public interface StrategyProjectPlansDao extends BaseEntityDao<StrategyProjectPlans> {

    @Query(value = "select * from strategy_project_plans where project_id = ?1", nativeQuery = true)
    List<StrategyProjectPlans> findByProjectId(String projectId);

    @DeleteMapping(value = "delete from StrategyProjectPlans where projectId = ?1")
    void deleteByProjectId(String id);
}
