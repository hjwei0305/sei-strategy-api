package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 项目负责人关联表(StrategyProjectOfficerRelation)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:22
 */
@ApiModel(description = "项目负责人关联表DTO")
public class StrategyProjectOfficerRelationDto extends BaseEntityDto {
    private static final long serialVersionUID = -67044700326665544L;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private String projectId;
    /**
     * 成员id
     */
    @ApiModelProperty(value = "成员id")
    private String userId;


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
