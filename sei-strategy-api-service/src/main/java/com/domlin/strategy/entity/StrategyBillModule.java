package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 经营策略模块(StrategyBillModule)实体类
 *
 * @author sei
 * @since 2023-05-09 15:10:14
 */
@Entity
@Table(name = "strategy_bill_module")
@DynamicInsert
@DynamicUpdate
public class StrategyBillModule extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 412574399525051193L;
    /**
     * 代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 模块
     */
    @Column(name = "module")
    private String module;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

}
