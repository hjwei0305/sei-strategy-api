package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 验证问题(StrategyProjectVerify)实体类
 *
 * @author sei
 * @since 2023-05-09 15:13:28
 */
@Entity
@Table(name = "strategy_project_verify")
@DynamicInsert
@DynamicUpdate
public class StrategyProjectVerify extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = -76447409025169827L;
    /**
     * 确认结果
     */
    @Column(name = "verify_result")
    private String verifyResult;
    /**
     * 确认类别
     */
    @Column(name = "verify_style")
    private String verifyStyle;
    /**
     * 问题点
     */
    @Column(name = "verify_point")
    private String verifyPoint;


    public String getVerifyResult() {
        return verifyResult;
    }

    public void setVerifyResult(String verifyResult) {
        this.verifyResult = verifyResult;
    }

    public String getVerifyStyle() {
        return verifyStyle;
    }

    public void setVerifyStyle(String verifyStyle) {
        this.verifyStyle = verifyStyle;
    }

    public String getVerifyPoint() {
        return verifyPoint;
    }

    public void setVerifyPoint(String verifyPoint) {
        this.verifyPoint = verifyPoint;
    }

}
