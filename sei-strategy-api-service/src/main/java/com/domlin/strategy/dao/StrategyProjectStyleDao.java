package com.domlin.strategy.dao;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.domlin.strategy.dto.StrategyProjectStyleDto;
import com.domlin.strategy.entity.StrategyProjectStyle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 项目类别(StrategyProjectStyle)数据库访问类
 *
 * @author sei
 * @since 2023-05-09 15:13:27
 */
@Repository
public interface StrategyProjectStyleDao extends BaseEntityDao<StrategyProjectStyle> {


//    @Modifying
//    @Query("update Account a set a.frozen = :frozen where a.id = :id")
//    int updateFrozen(@Param("id") String id, @Param("frozen") boolean frozen);

//    @Modifying
//    @Query("update StrategyProjectStyle s set s.code = :#{strategyProjectStyle.code},s.projectStyle = :#{#strategyProjectStyle.projectStyle} where s.id = :#{#strategyProjectStyle.id}")
//    int update(@Param("strategyProjectStyle") StrategyProjectStyleDto strategyProjectStyle);
}
