package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 经营策略(StrategyAnalyzeBill)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:09:59
 */
@ApiModel(description = "经营策略DTO")
public class StrategyAnalyzeBillDto extends BaseEntityDto {
    private static final long serialVersionUID = -19665181556150495L;
    /**
     * 年份
     */
    @ApiModelProperty(value = "年份")
    private String year;
    /**
     * 经营策略
     */
    @ApiModelProperty(value = "经营策略")
    private String strategyName;
    /**
     * 模块id
     */
    @ApiModelProperty(value = "模块id")
    private String moduleId;
    /**
     * 所属模块
     */
    @ApiModelProperty(value = "所属模块")
    private String module;
    /**
     * 单号
     */
    @ApiModelProperty(value = "单号")
    private String billNo;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String state;
    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private Date date;


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

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

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
