package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;


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
     * 模块code
     */
    @ApiModelProperty(value = "模块code")
    private String moduleCode;
    /**
     * 所属模块
     */
    @ApiModelProperty(value = "所属模块")
    private String module;
    /**
     * 单号
     */
    @ApiModelProperty(value = "单号")
    private String code;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String state;
    /**
     * 阶段
     */
    @ApiModelProperty(value = "阶段")
    private String stage;
    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private Date date;

    @ApiModelProperty(value = "创建人工号")
    protected String creatorAccount;

    @ApiModelProperty(value = "创建人")
    private String creatorName;

    @ApiModelProperty(value = "创建人职位")
    private String creatorPosition;

    @ApiModelProperty(value = "创建时间")
    private Date createdDate;

    @ApiModelProperty(value = "最后更新时间")
    private Date lastEditedDate;

    /**
     * 变更次数
     */
    @ApiModelProperty(value = "变更次数")
    private Integer changeCount;

    //保存用，查询不用
    @ApiModelProperty("strategyProjectDto的集合")
    private List<StrategyProjectDto> projectDtoList;

    //description
    @ApiModelProperty("description")
    private String description;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
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

    public Date getLastEditedDate() {
        return lastEditedDate;
    }

    public void setLastEditedDate(Date lastEditedDate) {
        this.lastEditedDate = lastEditedDate;
    }

    public Integer getChangeCount() {
        return changeCount;
    }

    public void setChangeCount(Integer changeCount) {
        this.changeCount = changeCount;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getCreatorPosition() {
        return creatorPosition;
    }

    public void setCreatorPosition(String creatorPosition) {
        this.creatorPosition = creatorPosition;
    }


    public List<StrategyProjectDto> getProjectDtoList() {
        return projectDtoList;
    }

    public void setProjectDtoList(List<StrategyProjectDto> projectDtoList) {
        this.projectDtoList = projectDtoList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
