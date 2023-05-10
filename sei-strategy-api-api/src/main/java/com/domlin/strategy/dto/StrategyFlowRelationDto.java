package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 项目与流程关联表(StrategyFlowRelation)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:12:32
 */
@ApiModel(description = "项目与流程关联表DTO")
public class StrategyFlowRelationDto extends BaseEntityDto {
    private static final long serialVersionUID = 268618514354439860L;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private String projectId;
    /**
     * 成员id
     */
    @ApiModelProperty(value = "成员id")
    private String flowId;


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

}
