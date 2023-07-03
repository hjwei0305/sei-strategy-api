package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.domlin.strategy.entity.StrategyUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 人员信息(StrategyUser)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:13:33
 */
@Repository
public interface StrategyUserDao extends BaseEntityDao<StrategyUser> {

    @Modifying
    @Query("select su from StrategyUser su where su.moduleCode = :moduleCode and su.style = 'contact'")
    List<StrategyUser> findByModuleCode(String moduleCode);

    @Query("select su from StrategyUser su where su.userCode = :userCode")
    StrategyUser findByUserCode(String userCode);

    //findOfficerByProjectId,通过projectID，查询StrategyProjectOfficerRelation表，获取officer的UserId，再通过UserId查询StrategyUser表，获取officer的信息
    @Query("select su from StrategyUser su where su.id in (select sp.userId from StrategyProjectOfficerRelation sp where sp.projectId = :projectId)")
    List<StrategyUser> findOfficerByProjectId(String projectId);

}
