//package com.domlin.strategy.entity;
//
//import com.changhong.sei.core.entity.BaseAuditableEntity;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import java.io.Serializable;
//
///**
// * 经营策略与管理组关联表(StrategyManageRelation)实体类
// *
// * @author sei
// * @since 2023-05-09 15:12:32
// */
//@Entity
//@Table(name = "strategy_manage_relation")
//@DynamicInsert
//@DynamicUpdate
//public class StrategyManageRelation extends BaseAuditableEntity implements Serializable {
//    private static final long serialVersionUID = 200462843699164344L;
//    /**
//     * 经营策略id
//     */
//    @Column(name = "strategy_id")
//    private String strategyId;
//    /**
//     * 经营策略管理组成员id
//     */
//    @Column(name = "user_id")
//    private String userId;
//
//
//    public String getStrategyId() {
//        return strategyId;
//    }
//
//    public void setStrategyId(String strategyId) {
//        this.strategyId = strategyId;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//}
