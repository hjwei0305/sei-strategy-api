package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 人员变更表(StrategyProjectChangeUser)实体类
 *
 * @author sei
 * @since 2023-05-09 15:13:04
 */
@Entity
@Table(name = "strategy_project_change_user")
@DynamicInsert
@DynamicUpdate
public class StrategyProjectChangeUser extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 525139833288347522L;
    /**
     * 项目id
     */
    @Column(name = "project_id")
    private String projectId;
    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;
    /**
     * 项目负责人工号
     */
    @Column(name = "officer_code")
    private String officerCode;
    /**
     * 项目负责人名字
     */
    @Column(name = "officer_name")
    private String officerName;
    /**
     * 项目负责人id
     */
    @Column(name = "officer_id")
    private String officerId;
    /**
     * 部门
     */
    @Column(name = "department")
    private String department;
    /**
     * 模块
     */
    @Column(name = "module")
    private String module;
    /**
     * 项目级别
     */
    @Column(name = "project_level")
    private String projectLevel;
    /**
     * 项目类别
     */
    @Column(name = "project_style")
    private String projectStyle;
    /**
     * 变更类型
     */
    @Column(name = "strategy")
    private String strategy;
    /**
     * 变更原因
     */
    @Column(name = "reason")
    private String reason;
    /**
     * 原内容
     */
    @Column(name = "change_before")
    private String changeBefore;
    /**
     * 变更后内容
     */
    @Column(name = "change_after")
    private String changeAfter;


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOfficerCode() {
        return officerCode;
    }

    public void setOfficerCode(String officerCode) {
        this.officerCode = officerCode;
    }

    public String getOfficerName() {
        return officerName;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public String getOfficerId() {
        return officerId;
    }

    public void setOfficerId(String officerId) {
        this.officerId = officerId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getProjectLevel() {
        return projectLevel;
    }

    public void setProjectLevel(String projectLevel) {
        this.projectLevel = projectLevel;
    }

    public String getProjectStyle() {
        return projectStyle;
    }

    public void setProjectStyle(String projectStyle) {
        this.projectStyle = projectStyle;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getChangeBefore() {
        return changeBefore;
    }

    public void setChangeBefore(String changeBefore) {
        this.changeBefore = changeBefore;
    }

    public String getChangeAfter() {
        return changeAfter;
    }

    public void setChangeAfter(String changeAfter) {
        this.changeAfter = changeAfter;
    }

}
