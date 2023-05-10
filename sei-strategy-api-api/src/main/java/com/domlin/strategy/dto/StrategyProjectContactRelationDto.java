package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 项目对接人员关联表(StrategyProjectContactRelation)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:09
 */
@ApiModel(description = "项目对接人员关联表DTO")
public class StrategyProjectContactRelationDto extends BaseEntityDto {
    private static final long serialVersionUID = 798321908141377020L;
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
