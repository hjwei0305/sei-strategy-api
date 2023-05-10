package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 项目与模块关联表(StrategyProjectModuleRelation)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:21
 */
@ApiModel(description = "项目与模块关联表DTO")
public class StrategyProjectModuleRelationDto extends BaseEntityDto {
    private static final long serialVersionUID = 728506876480664034L;
    /**
     * 项目id
     */
    @ApiModelProperty(value = "项目id")
    private String projectId;
    /**
     * 成员id
     */
    @ApiModelProperty(value = "成员id")
    private String modulerId;


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getModulerId() {
        return modulerId;
    }

    public void setModulerId(String modulerId) {
        this.modulerId = modulerId;
    }

}
