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
    @Column(name = "module_id")
    private String moduleId;
    /**
     * 所属模块
     */
    @Column(name = "module")
    private String module;
    /**
     * 单号
     */
    @Column(name = "bill_no")
    private String billNo;
    /**
     * 状态
     */
    @Column(name = "state")
    private String state;
    /**
     * 日期
     */
    @Column(name = "date")
    private Date date;


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

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
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

}
