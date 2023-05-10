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
     * 实际提交时间
     */
    @ApiModelProperty(value = "实际提交时间")
    private Date submitDate;
    /**
     * 提交人姓名
     */
    @ApiModelProperty(value = "提交人姓名")
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
