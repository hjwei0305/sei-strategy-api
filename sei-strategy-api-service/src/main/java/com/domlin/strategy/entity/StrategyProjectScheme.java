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
 * 周期配置(StrategyProjectScheme)实体类
 *
 * @author sei
 * @since 2023-05-09 15:13:25
 */
@Entity
@Table(name = "strategy_project_scheme")
@DynamicInsert
@DynamicUpdate
public class StrategyProjectScheme extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = -64464752894250610L;
    /**
     * 类别
     */
    @Column(name = "style")
    private String style;
    /**
     * 确认类别
     */
    @Column(name = "schedule")
    private String schedule;
    /**
     * 实际提交时间
     */
    @Column(name = "submit_date")
    private Date submitDate;
    /**
     * 提交人姓名
     */
    @Column(name = "submit_by")
    private String submitBy;


    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getSubmitBy() {
        return submitBy;
    }

    public void setSubmitBy(String submitBy) {
        this.submitBy = submitBy;
    }

}
