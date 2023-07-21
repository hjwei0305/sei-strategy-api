package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 行动计划表单(StrategyProjectPlans)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:23
 */
@ApiModel(description = "行动计划表单DTO")
public class StrategyProjectPlansDto extends BaseEntityDto {
    private static final long serialVersionUID = -49733211097626463L;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private String projectId;
    /**
     * 月份
     */
    @ApiModelProperty(value = "月份")
    private String month;
    /**
     * userId
     */
    @ApiModelProperty(value = "userId")
    private String userId;
    /**
     * 责任人code
     */
    @ApiModelProperty(value = "责任人code")
    private String userCode;
    /**
     * 责任人
     */
    @ApiModelProperty(value = "责任人")
    private String userName;
    /**
     * 里程碑
     */
    @ApiModelProperty(value = "里程碑")
    private String milestone;
    /**
     * 预计完成日期
     */
    @ApiModelProperty(value = "预计完成日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date estimateDate;
    /**
     * 交付物
     */
    @ApiModelProperty(value = "交付物")
    private String deliverable;
    /**
     * 是否财务数据
     */
    @ApiModelProperty(value = "是否财务数据")
    private Boolean isFinancial;
    /**
     * 延迟天数
     */
    @ApiModelProperty(value = "延迟天数")
    private Integer overdueDays;
    /**
     * 完成日期
     */
    @ApiModelProperty(value = "完成日期")
    private Date finishDate;


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMilestone() {
        return milestone;
    }

    public void setMilestone(String milestone) {
        this.milestone = milestone;
    }

    public Date getEstimateDate() {
        return estimateDate;
    }

    public void setEstimateDate(Date estimateDate) {
        this.estimateDate = estimateDate;
    }

    public String getDeliverable() {
        return deliverable;
    }

    public void setDeliverable(String deliverable) {
        this.deliverable = deliverable;
    }

    public Boolean getIsFinancial() {
        return isFinancial;
    }

    public void setIsFinancial(Boolean isFinancial) {
        this.isFinancial = isFinancial;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getFinancial() {
        return isFinancial;
    }

    public void setFinancial(Boolean financial) {
        isFinancial = financial;
    }
}
