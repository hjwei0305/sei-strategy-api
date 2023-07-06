package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 人员信息(StrategyUser)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:34
 */
@ApiModel(description = "人员信息DTO")
public class StrategyUserDto extends BaseEntityDto {
    private static final long serialVersionUID = 488041643143088268L;
    /**
     * module_id
     */
    @ApiModelProperty(value = "module_Code")
    private String moduleCode;
    /**
     * 模块
     */
    @ApiModelProperty(value = "模块")
    private String module;
    /**
     * 人员类别
     */
    @ApiModelProperty(value = "人员类别")
    private String style;
    /**
     * user表id
     */
    @ApiModelProperty(value = "user表id")
    private String userId;
    /**
     * user表工号
     */
    @ApiModelProperty(value = "user表工号")
    private String userCode;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String userName;
    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    private String department;
    /**
     * 人员状态
     */
    @ApiModelProperty(value = "人员状态")
    private String userState;

    @ApiModelProperty(value = "创建人")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    private Date createdDate;

    /**
     * 人员职位
     */
    @ApiModelProperty(value = "position")
    private String position;


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

    public String getuserState() {
        return userState;
    }

    public void setuserState(String userState) {
        this.userState = userState;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
