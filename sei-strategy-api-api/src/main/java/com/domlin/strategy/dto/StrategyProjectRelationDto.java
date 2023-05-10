package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 经营策略与项目关联表(StrategyProjectRelation)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:25
 */
@ApiModel(description = "经营策略与项目关联表DTO")
public class StrategyProjectRelationDto extends BaseEntityDto {
    private static final long serialVersionUID = -72676398596227196L;
    /**
     * 经营策略id
     */
    @ApiModelProperty(value = "经营策略id")
    private String strategyId;
    /**
     * 经营策略管理组成员id
     */
    @ApiModelProperty(value = "经营策略管理组成员id")
    private String projectId;


    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

}
