package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 经营策略与项目关联表(StrategyProjectRelation)实体类
 *
 * @author sei
 * @since 2023-05-09 15:13:24
 */
@Entity
@Table(name = "strategy_project_relation")
@DynamicInsert
@DynamicUpdate
public class StrategyProjectRelation extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 927161009036221008L;
    /**
     * 经营策略id
     */
    @Column(name = "strategy_id")
    private String strategyId;
    /**
     * 经营策略管理组成员id
     */
    @Column(name = "project_id")
    private String projectId;


    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

}
