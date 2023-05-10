package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 经营策略与管理组关联表(StrategyManageRelation)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:12:34
 */
@ApiModel(description = "经营策略与管理组关联表DTO")
public class StrategyManageRelationDto extends BaseEntityDto {
    private static final long serialVersionUID = -82182672371857341L;
    /**
     * 经营策略id
     */
    @ApiModelProperty(value = "经营策略id")
    private String strategyId;
    /**
     * 经营策略管理组成员id
     */
    @ApiModelProperty(value = "经营策略管理组成员id")
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
