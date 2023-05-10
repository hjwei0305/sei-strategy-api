package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 人员变更明细表(StrategyProjectChangeDetail)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:00
 */
@ApiModel(description = "人员变更明细表DTO")
public class StrategyProjectChangeDetailDto extends BaseEntityDto {
    private static final long serialVersionUID = 298707861728926972L;
    /**
     * 人员变更id
     */
    @ApiModelProperty(value = "人员变更id")
    private String projectChangeId;
    /**
     * 人员变更类别
     */
    @ApiModelProperty(value = "人员变更类别")
    private String changeStyle;
    /**
     * 变更前人员id
     */
    @ApiModelProperty(value = "变更前人员id")
    private String beforeId;
    /**
     * 变更前工号
     */
    @ApiModelProperty(value = "变更前工号")
    private String beforeCode;
    /**
     * 变更前人员姓名
     */
    @ApiModelProperty(value = "变更前人员姓名")
    private String beforeName;
    /**
     * 变更前部门
     */
    @ApiModelProperty(value = "变更前部门")
    private String beforeDepartment;
    /**
     * 变更后人员id
     */
    @ApiModelProperty(value = "变更后人员id")
    private String afterId;
    /**
     * 变更后工号
     */
    @ApiModelProperty(value = "变更后工号")
    private String afterCode;
    /**
     * 变更后人员姓名
     */
    @ApiModelProperty(value = "变更后人员姓名")
    private String afterName;
    /**
     * 变更后部门
     */
    @ApiModelProperty(value = "变更后部门")
    private String afterDepartment;


    public String getProjectChangeId() {
        return projectChangeId;
    }

    public void setProjectChangeId(String projectChangeId) {
        this.projectChangeId = projectChangeId;
    }

    public String getChangeStyle() {
        return changeStyle;
    }

    public void setChangeStyle(String changeStyle) {
        this.changeStyle = changeStyle;
    }

    public String getBeforeId() {
        return beforeId;
    }

    public void setBeforeId(String beforeId) {
        this.beforeId = beforeId;
    }

    public String getBeforeCode() {
        return beforeCode;
    }

    public void setBeforeCode(String beforeCode) {
        this.beforeCode = beforeCode;
    }

    public String getBeforeName() {
        return beforeName;
    }

    public void setBeforeName(String beforeName) {
        this.beforeName = beforeName;
    }

    public String getBeforeDepartment() {
        return beforeDepartment;
    }

    public void setBeforeDepartment(String beforeDepartment) {
        this.beforeDepartment = beforeDepartment;
    }

    public String getAfterId() {
        return afterId;
    }

    public void setAfterId(String afterId) {
        this.afterId = afterId;
    }

    public String getAfterCode() {
        return afterCode;
    }

    public void setAfterCode(String afterCode) {
        this.afterCode = afterCode;
    }

    public String getAfterName() {
        return afterName;
    }

    public void setAfterName(String afterName) {
        this.afterName = afterName;
    }

    public String getAfterDepartment() {
        return afterDepartment;
    }

    public void setAfterDepartment(String afterDepartment) {
        this.afterDepartment = afterDepartment;
    }

}
