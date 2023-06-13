package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 经营策略(StrategyAnalyzeBill)实体类
 *
 * @author sei
 * @since 2023-05-09 15:09:55
 */
@Entity
@Table(name = "strategy_analyze_bill")
@DynamicInsert
@DynamicUpdate
public class StrategyAnalyzeBill extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 393942144967883467L;
    /**
     * 年份
     */
    @Column(name = "year")
    private String year;
    /**
     * 经营策略
     */
    @Column(name = "strategy_name")
    private String strategyName;
    /**
     * 模块id
     */
    @Column(name = "module_code")
    private String moduleCode;
    /**
     * 所属模块
     */
    @Column(name = "module")
    private String module;
    /**
     * 单号
     */
    @Column(name = "code")
    private String code;
    /**
     * 状态
     */
    @Column(name = "state")
    private String state;
    /**
     * 阶段
     */
    @Column(name = "stage")
    private String stage;
    /**
     * 日期
     */
    @Column(name = "date")
    private Date date;
    /**
     * 变更次数
     */
    @Column(name = "change_count")
    private Integer changeCount;

    /**
     * description
     */
    @Column(name = "description")
    private String description;


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
