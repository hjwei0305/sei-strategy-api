package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 项目类别(StrategyProjectStyle)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:28
 */
@ApiModel(description = "项目类别DTO")
public class StrategyProjectStyleDto extends BaseEntityDto {
    private static final long serialVersionUID = 529981939376015412L;
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 项目类别
     */
    @ApiModelProperty(value = "项目类别")
    private String projectStyle;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProjectStyle() {
        return projectStyle;
    }

    public void setProjectStyle(String projectStyle) {
        this.projectStyle = projectStyle;
    }

}
