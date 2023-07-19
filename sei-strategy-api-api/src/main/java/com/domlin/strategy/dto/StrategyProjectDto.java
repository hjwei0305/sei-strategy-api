package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 项目(StrategyProject)DTO类
 *
 * @author wake
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
    private Boolean isPastFirstTrial;
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
     * 前端展示用，千万必要用来处理业务逻辑
     */
    private String officerCodes;

    /**
     * 前端展示用，千万必要用来处理业务逻辑
     */
    private String officerNames;

    /**
     * 前端展示用，千万必要用来处理业务逻辑
     */
    private String officerPositions;

    /**
     * 策略负责人
     */
    private List<StrategyUserDto> officers;

    /**
     * 策略管理员
     */
    private List<StrategyUserDto> managers;

    /**
     * 策略联系人
     */
    private List<StrategyUserDto> contacts;

    /**
     * 单位负责人
     */
    private List<StrategyUserDto> unitManagers;

    /**
     * 项目相关方
     */
    private List<StrategyUserDto> relates;

    /**
     * 项目计划
     */
    private List<StrategyProjectPlansDto> plans;

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

    public Boolean getIsPastFirstTrial() {
        return isPastFirstTrial;
    }

    public void setIsPastFirstTrial(Boolean isPastFirstTrial) {
        this.isPastFirstTrial = isPastFirstTrial;
    }

    public Date getFirstTrialDate() {
        return firstTrialDate;
    }

    public void setFirstTrialDate(Date firstTrialDate) {
        this.firstTrialDate = firstTrialDate;
    }

    public List<StrategyUserDto> getOfficers() {
        return officers;
    }

    public void setOfficers(List<StrategyUserDto> officers) {
        this.officers = officers;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public List<StrategyUserDto> getManagers() {
        return managers;
    }

    public void setManagers(List<StrategyUserDto> managers) {
        this.managers = managers;
    }

    public List<StrategyUserDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<StrategyUserDto> contacts) {
        this.contacts = contacts;
    }

    public List<StrategyUserDto> getUnitManagers() {
        return unitManagers;
    }

    public void setUnitManagers(List<StrategyUserDto> unitManagers) {
        this.unitManagers = unitManagers;
    }

    public String getOfficerCodes() {
        return officerCodes;
    }

    public void setOfficerCodes(String officerCodes) {
        this.officerCodes = officerCodes;
    }

    public String getOfficerNames() {
        return officerNames;
    }

    public void setOfficerNames(String officerNames) {
        this.officerNames = officerNames;
    }

    public String getOfficerPositions() {
        return officerPositions;
    }

    public void setOfficerPositions(String officerPositions) {
        this.officerPositions = officerPositions;
    }

    public List<StrategyUserDto> getRelates() {
        return relates;
    }

    public void setRelates(List<StrategyUserDto> relates) {
        this.relates = relates;
    }

    public List<StrategyProjectPlansDto> getPlans() {
        return plans;
    }

    public void setPlans(List<StrategyProjectPlansDto> plans) {
        this.plans = plans;
    }
}
