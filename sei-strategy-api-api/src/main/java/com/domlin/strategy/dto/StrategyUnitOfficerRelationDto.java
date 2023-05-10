package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 经营策略与单位负责人关联表(StrategyUnitOfficerRelation)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:32
 */
@ApiModel(description = "经营策略与单位负责人关联表DTO")
public class StrategyUnitOfficerRelationDto extends BaseEntityDto {
    private static final long serialVersionUID = 711792836874372851L;
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
