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
 * 项目(StrategyProject)实体类
 *
 * @author sei
 * @since 2023-05-09 15:12:46
 */
@Entity
@Table(name = "strategy_project")
@DynamicInsert
@DynamicUpdate
public class StrategyProject extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 137615013293557012L;
    /**
     * 项目名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 项目等级
     */
    @Column(name = "level")
    private String level;
    /**
     * 项目类型
     */
    @Column(name = "style")
    private String style;
    /**
     * 项目编号
     */
    @Column(name = "code")
    private String code;
    /**
     * 最后修改时间
     */
    @Column(name = "submit_date")
    private Date submitDate;
    /**
     * 项目内容
     */
    @Column(name = "content")
    private String content;
    /**
     * 项目价值
     */
    @Column(name = "significance")
    private String significance;
    /**
     * 项目目标
     */
    @Column(name = "target")
    private String target;
    /**
     * 初审是否通过
     */
    @Column(name = "is_past_first_trial")
    private Boolean isPastFirstTrial;
    /**
     * 初审日期
     */
    @Column(name = "first_trial_date")
    private Date firstTrialDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSignificance() {
        return significance;
    }

    public void setSignificance(String significance) {
        this.significance = significance;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Boolean getIsPastFirstTrial() {
        return isPastFirstTrial;
    }

    public void setIsPastFirstTrial(Boolean isPastFirstTrial) {
        this.isPastFirstTrial = isPastFirstTrial;
    }

    public Date getFirstTrialDate() {
        return firstTrialDate;
    }

    public void setFirstTrialDate(Date firstTrialDate) {
        this.firstTrialDate = firstTrialDate;
    }

}
