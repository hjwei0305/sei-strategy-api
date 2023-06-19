package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 项目变更表(StrategyProjectChange)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:12:53
 */
@ApiModel(description = "项目变更表DTO")
public class StrategyProjectChangeDto extends BaseEntityDto {
    private static final long serialVersionUID = 781059358856080704L;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private String projectId;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String projectName;
    /**
     * 项目负责人工号
     */
    @ApiModelProperty(value = "项目负责人工号")
    private String officerCode;
    /**
     * 项目负责人名字
     */
    @ApiModelProperty(value = "项目负责人名字")
    private String officerName;
    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    private String department;
    /**
     * 模块
     */
    @ApiModelProperty(value = "模块")
    private String module;
    /**
     * 项目级别
     */
    @ApiModelProperty(value = "项目级别")
    private String projectLevel;
    /**
     * 项目类别
     */
    @ApiModelProperty(value = "项目类别")
    private String projectStyle;
    /**
     * 变更类型
     */
    @ApiModelProperty(value = "变更类型")
    private String changeStyle;
    /**
     * 变更类型
     */
    @ApiModelProperty(value = "变更类型")
    private String strategy;
    /**
     * 变更原因
     */
    @ApiModelProperty(value = "变更原因")
    private String reason;
    /**
     * 原内容
     */
    @ApiModelProperty(value = "原内容")
    private String changeBefore;
    /**
     * 变更后内容
     */
    @ApiModelProperty(value = "变更后内容")
    private String changeAfter;


    @ApiModelProperty(value = "创建人")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    private Date createdDate;

    @ApiModelProperty(value = "position")
    private String position;

    @ApiModelProperty(value = "stage")
    private String stage;

    @ApiModelProperty(value = "projectCode")
    private String projectCode;

    @ApiModelProperty(value = "effectiveDate")
    private Date effectiveDate;


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

    public String getChangeStyle() {
        return changeStyle;
    }

    public void setChangeStyle(String changeStyle) {
        this.changeStyle = changeStyle;
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

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
