package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyRelatedRelation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * 项目相关人员关联表(StrategyRelatedRelation)数据库访问类
 *
 * @author wake
 * @since 2023-05-09 15:13:30
 */
@Repository
public interface StrategyRelatedRelationDao extends BaseEntityDao<StrategyRelatedRelation> {

    @Query(value = "select count(id) from StrategyRelatedRelation where projectId = ?1 and userId = ?2")
    Integer countByProjectAndUserId(String id, String id1);

    @DeleteMapping(value = "delete from StrategyRelatedRelation where projectId = ?1")
    void deleteByProjectId(String id);
}
