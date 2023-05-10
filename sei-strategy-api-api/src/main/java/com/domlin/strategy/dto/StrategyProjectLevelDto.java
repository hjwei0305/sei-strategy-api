package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 项目分级(StrategyProjectLevel)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:20
 */
@ApiModel(description = "项目分级DTO")
public class StrategyProjectLevelDto extends BaseEntityDto {
    private static final long serialVersionUID = -21279193434506536L;
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 等级
     */
    @ApiModelProperty(value = "等级")
    private String level;
    /**
     * 范围
     */
    @ApiModelProperty(value = "范围")
    private String scope;
    /**
     * 产品线
     */
    @ApiModelProperty(value = "产品线")
    private String productLine;
    /**
     * 公司重点关注项目
     */
    @ApiModelProperty(value = "公司重点关注项目")
    private String importantProject;
    /**
     * 运行阶段
     */
    @ApiModelProperty(value = "运行阶段")
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
