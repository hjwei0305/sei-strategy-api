package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 项目与流程关联表(StrategyFlowRelation)实体类
 *
 * @author sei
 * @since 2023-05-09 15:12:30
 */
@Entity
@Table(name = "strategy_flow_relation")
@DynamicInsert
@DynamicUpdate
public class StrategyFlowRelation extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 839666392105230018L;
    /**
     * 项目id
     */
    @Column(name = "project_id")
    private String projectId;
    /**
     * 成员id
     */
    @Column(name = "flow_id")
    private String flowId;


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

}
