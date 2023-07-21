package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 行动计划表单(StrategyProjectPlans)实体类
 *
 * @author sei
 * @since 2023-05-09 15:13:23
 */
@Entity
@Table(name = "strategy_project_plans")
@DynamicInsert
@DynamicUpdate
public class StrategyProjectPlans extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 723746183402597486L;
    /**
     * 项目id
     */
    @Column(name = "project_id")
    private String projectId;
    /**
     * 月份
     */
    @Column(name = "month")
    private String month;
    /**
     * 责任人code
     */
    @ApiModelProperty(value = "责任人code")
    @Column(name = "user_code")
    private String userCode;
    /**
     * 责任人
     */
    @ApiModelProperty(value = "责任人")
    @Column(name = "user_name")
    private String userName;
    /**
     * 里程碑
     */
    @Column(name = "milestone")
    private String milestone;
    /**
     * 预计完成日期
     */
    @Column(name = "estimate_date")
    private Date estimateDate;
    /**
     * 交付物
     */
    @Column(name = "deliverable")
    private String deliverable;
    /**
     * 是否财务数据
     */
    @Column(name = "is_financial")
    private Boolean isFinancial= Boolean.FALSE;
    /**
     * 延迟天数
     */
    @Column(name = "overdue_days")
    private Integer overdueDays;
    /**
     * 完成日期
     */
    @Column(name = "finish_date")
    private Date finishDate;
    /**
     * user表id
     */
    @Column(name = "user_id")
    private String userId;


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

    public Boolean getFinancial() {
        return isFinancial;
    }

    public void setFinancial(Boolean financial) {
        isFinancial = financial;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
