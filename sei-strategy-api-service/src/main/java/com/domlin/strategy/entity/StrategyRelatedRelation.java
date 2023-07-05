package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 项目相关方关联表(StrategyRelatedRelation)实体类
 *
 * @author wake
 * @since 2023-05-09 15:13:30
 */
@Entity
@Table(name = "strategy_related_relation")
@DynamicInsert
@DynamicUpdate
public class StrategyRelatedRelation extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 150199770643235829L;
    /**
     * 项目id
     */
    @Column(name = "project_id")
    private String projectId;
    /**
     * 成员id
     */
    @Column(name = "user_id")
    private String userId;


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
