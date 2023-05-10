package com.domlin.strategy.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 人员信息(StrategyUser)实体类
 *
 * @author sei
 * @since 2023-05-09 15:13:33
 */
@Entity
@Table(name = "strategy_user")
@DynamicInsert
@DynamicUpdate
public class StrategyUser extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 865482175419900646L;
    /**
     * module_id
     */
    @Column(name = "module_id")
    private String moduleId;
    /**
     * 模块
     */
    @Column(name = "module")
    private String module;
    /**
     * 人员类别
     */
    @Column(name = "style")
    private String style;
    /**
     * user表id
     */
    @Column(name = "user_id")
    private String userId;
    /**
     * user表工号
     */
    @Column(name = "user_code")
    private String userCode;
    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 部门
     */
    @Column(name = "department")
    private String department;
    /**
     * 人员状态
     */
    @Column(name = "user_statue")
    private String userStatue;


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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUserStatue() {
        return userStatue;
    }

    public void setUserStatue(String userStatue) {
        this.userStatue = userStatue;
    }

}
