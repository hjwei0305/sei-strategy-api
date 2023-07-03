package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyContactRelation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 经营策略与项目联系人关联表(StrategyContactRelation)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:12:22
 */
@Repository
public interface StrategyContactRelationDao extends BaseEntityDao<StrategyContactRelation> {


    @Query(value = "select count(id) from StrategyContactRelation where projectId = ?1 and userId = ?2")
    Integer countByProjectAndUserId(String projectId, String userId);
}
