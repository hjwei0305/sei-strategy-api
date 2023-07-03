package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 经营策略与项目联系人关联表(StrategyContactRelation)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:12:24
 */
@ApiModel(description = "经营策略与项目联系人关联表DTO")
public class StrategyContactRelationDto extends BaseEntityDto {
    private static final long serialVersionUID = -17307498840180054L;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private String projectId;

    /**
     * 经营策略成员id
     */
    @ApiModelProperty(value = "经营策略成员id")
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
