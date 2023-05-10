package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 经营策略与模块负责人关联表(StrategyModuleRelation)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:12:39
 */
@ApiModel(description = "经营策略与模块负责人关联表DTO")
public class StrategyModuleRelationDto extends BaseEntityDto {
    private static final long serialVersionUID = -71221072183714168L;
    /**
     * 经营策略id
     */
    @ApiModelProperty(value = "经营策略id")
    private String strategyId;
    /**
     * 经营策略成员id
     */
    @ApiModelProperty(value = "经营策略成员id")
    private String userId;


    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
