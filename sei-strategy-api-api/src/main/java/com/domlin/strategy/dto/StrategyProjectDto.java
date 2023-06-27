package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 项目(StrategyProject)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:12:51
 */
@ApiModel(description = "项目DTO")
public class StrategyProjectDto extends BaseEntityDto {
    private static final long serialVersionUID = 976187078714851835L;
    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String name;
    /**
     * 项目等级
     */
    @ApiModelProperty(value = "项目等级")
    private String level;
    /**
     * 项目类型
     */
    @ApiModelProperty(value = "项目类型")
    private String style;
    /**
     * 项目编号
     */
    @ApiModelProperty(value = "项目编号")
    private String code;
    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间")
    private Date submitDate;
    /**
     * 项目内容
     */
    @ApiModelProperty(value = "项目内容")
    private String content;
    /**
     * 项目价值
     */
    @ApiModelProperty(value = "项目价值")
    private String significance;
    /**
     * 项目目标
     */
    @ApiModelProperty(value = "项目目标")
    private String target;
    /**
     * 初审是否通过
     */
    @ApiModelProperty(value = "初审是否通过")
    private Object isPastFirstTrial;
    /**
     * 初审日期
     */
    @ApiModelProperty(value = "初审日期")
    private Date firstTrialDate;


    /**
     * 项目阶段
     */
    @ApiModelProperty(value = "项目阶段")
    private String stage;

    /**
     * 策略负责人
     */
    private StrategyUserDto offcer;

    /**
     * 策略管理员
     */
    private StrategyUserDto manager;


    /**
     * 策略联系人
     */
    private StrategyUserDto contact;


    /**
     * 单位负责人
     */
    private StrategyUserDto unitManager;



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

    public Object getIsPastFirstTrial() {
        return isPastFirstTrial;
    }

    public void setIsPastFirstTrial(Object isPastFirstTrial) {
        this.isPastFirstTrial = isPastFirstTrial;
    }

    public Date getFirstTrialDate() {
        return firstTrialDate;
    }

    public void setFirstTrialDate(Date firstTrialDate) {
        this.firstTrialDate = firstTrialDate;
    }

    public StrategyUserDto getOffcer() {
        return offcer;
    }

    public void setOffcer(StrategyUserDto offcer) {
        this.offcer = offcer;
    }

    public StrategyUserDto getManager() {
        return manager;
    }

    public void setManager(StrategyUserDto manager) {
        this.manager = manager;
    }

    public StrategyUserDto getContact() {
        return contact;
    }

    public void setContact(StrategyUserDto contact) {
        this.contact = contact;
    }

    public StrategyUserDto getUnitManager() {
        return unitManager;
    }

    public void setUnitManager(StrategyUserDto unitManager) {
        this.unitManager = unitManager;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
}
