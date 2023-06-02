package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 周期配置(StrategyProjectScheme)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:26
 */
@ApiModel(description = "周期配置DTO")
public class StrategyProjectSchemeDto extends BaseEntityDto {
    private static final long serialVersionUID = 836827190508621216L;
    /**
     * 类别
     */
    @ApiModelProperty(value = "类别")
    private String style;
    /**
     * 确认类别
     */
    @ApiModelProperty(value = "确认类别")
    private String schedule;

    /**
     * 最后提交日期
     */
    @ApiModelProperty(value = "最后提交日期")
    private String scheduleOver;


    /**
     * user表工号
     */
    @ApiModelProperty(value = "user表工号")
    private String userCode;

    /**
     * 提交人姓名
     */
    @ApiModelProperty(value = "提交人姓名")
    private String submitBy;
    /**
     * department
     */
    @ApiModelProperty(value = "department")
    private String department;

    @ApiModelProperty(value = "创建人")
    private String creatorName;

    @ApiModelProperty(value = "创建时间")
    private Date createdDate;


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

    public String getSubmitBy() {
        return submitBy;
    }

    public void setSubmitBy(String submitBy) {
        this.submitBy = submitBy;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getScheduleOver() {
        return scheduleOver;
    }

    public void setScheduleOver(String scheduleOver) {
        this.scheduleOver = scheduleOver;
    }
}
