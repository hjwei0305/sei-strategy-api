package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 项目分级(StrategyProjectLevel)实体类
 *
 * @author sei
 * @since 2023-05-09 15:13:19
 */
@Entity
@Table(name = "strategy_project_level")
@DynamicInsert
@DynamicUpdate
public class StrategyProjectLevel extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 516624022909412134L;
    /**
     * 代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 等级
     */
    @Column(name = "level")
    private String level;
    /**
     * 范围
     */
    @Column(name = "scope")
    private String scope;
    /**
     * 产品线
     */
    @Column(name = "product_line")
    private String productLine;
    /**
     * 公司重点关注项目
     */
    @Column(name = "important_project")
    private String importantProject;
    /**
     * 运行阶段
     */
    @Column(name = "stage")
    private String stage;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getImportantProject() {
        return importantProject;
    }

    public void setImportantProject(String importantProject) {
        this.importantProject = importantProject;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

}
