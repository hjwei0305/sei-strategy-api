package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 项目类别(StrategyProjectStyle)实体类
 *
 * @author sei
 * @since 2023-05-09 15:13:27
 */
@Entity
@Table(name = "strategy_project_style")
@DynamicInsert
@DynamicUpdate
public class StrategyProjectStyle extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = -45297373063203122L;
    /**
     * 代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 项目类别
     */
    @Column(name = "project_style")
    private String projectStyle;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProjectStyle() {
        return projectStyle;
    }

    public void setProjectStyle(String projectStyle) {
        this.projectStyle = projectStyle;
    }

}
