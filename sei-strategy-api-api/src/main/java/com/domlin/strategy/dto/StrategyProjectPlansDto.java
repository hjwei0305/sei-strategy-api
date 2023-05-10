package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
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
     * 里程碑
     */
    @ApiModelProperty(value = "里程碑")
    private String milestone;
    /**
     * 预计完成日期
     */
    @ApiModelProperty(value = "预计完成日期")
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
    private Object isFinancial;
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

    public Object getIsFinancial() {
        return isFinancial;
    }

    public void setIsFinancial(Object isFinancial) {
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

}
