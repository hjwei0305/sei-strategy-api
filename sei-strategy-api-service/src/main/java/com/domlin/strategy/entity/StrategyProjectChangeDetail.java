package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 人员变更明细表(StrategyProjectChangeDetail)实体类
 *
 * @author sei
 * @since 2023-05-09 15:12:59
 */
@Entity
@Table(name = "strategy_project_change_detail")
@DynamicInsert
@DynamicUpdate
public class StrategyProjectChangeDetail extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = -53258703017553355L;
    /**
     * 人员变更id
     */
    @Column(name = "project_change_id")
    private String projectChangeId;
    /**
     * 人员变更类别
     */
    @Column(name = "change_style")
    private String changeStyle;
    /**
     * 变更前人员id
     */
    @Column(name = "before_id")
    private String beforeId;
    /**
     * 变更前工号
     */
    @Column(name = "before_code")
    private String beforeCode;
    /**
     * 变更前人员姓名
     */
    @Column(name = "before_name")
    private String beforeName;
    /**
     * 变更前部门
     */
    @Column(name = "before_department")
    private String beforeDepartment;
    /**
     * 变更后人员id
     */
    @Column(name = "after_id")
    private String afterId;
    /**
     * 变更后工号
     */
    @Column(name = "after_code")
    private String afterCode;
    /**
     * 变更后人员姓名
     */
    @Column(name = "after_name")
    private String afterName;
    /**
     * 变更后部门
     */
    @Column(name = "after_department")
    private String afterDepartment;


    public String getProjectChangeId() {
        return projectChangeId;
    }

    public void setProjectChangeId(String projectChangeId) {
        this.projectChangeId = projectChangeId;
    }

    public String getChangeStyle() {
        return changeStyle;
    }

    public void setChangeStyle(String changeStyle) {
        this.changeStyle = changeStyle;
    }

    public String getBeforeId() {
        return beforeId;
    }

    public void setBeforeId(String beforeId) {
        this.beforeId = beforeId;
    }

    public String getBeforeCode() {
        return beforeCode;
    }

    public void setBeforeCode(String beforeCode) {
        this.beforeCode = beforeCode;
    }

    public String getBeforeName() {
        return beforeName;
    }

    public void setBeforeName(String beforeName) {
        this.beforeName = beforeName;
    }

    public String getBeforeDepartment() {
        return beforeDepartment;
    }

    public void setBeforeDepartment(String beforeDepartment) {
        this.beforeDepartment = beforeDepartment;
    }

    public String getAfterId() {
        return afterId;
    }

    public void setAfterId(String afterId) {
        this.afterId = afterId;
    }

    public String getAfterCode() {
        return afterCode;
    }

    public void setAfterCode(String afterCode) {
        this.afterCode = afterCode;
    }

    public String getAfterName() {
        return afterName;
    }

    public void setAfterName(String afterName) {
        this.afterName = afterName;
    }

    public String getAfterDepartment() {
        return afterDepartment;
    }

    public void setAfterDepartment(String afterDepartment) {
        this.afterDepartment = afterDepartment;
    }

}
