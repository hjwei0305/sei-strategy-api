package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyProjectOfficerRelation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * 项目负责人关联表(StrategyProjectOfficerRelation)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:13:22
 */
@Repository
public interface StrategyProjectOfficerRelationDao extends BaseEntityDao<StrategyProjectOfficerRelation> {

    @Query(value = "select count(id) from StrategyProjectOfficerRelation where projectId = ?1 and userId = ?2")
    Integer countByProjectAndUserId(String projectId, String userId);

    @DeleteMapping(value = "delete from StrategyProjectOfficerRelation where projectId = ?1")
    void deleteByProjectId(String projectId);


}
