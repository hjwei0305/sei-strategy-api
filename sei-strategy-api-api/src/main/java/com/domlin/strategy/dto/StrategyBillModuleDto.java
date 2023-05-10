package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 经营策略模块(StrategyBillModule)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:10:15
 */
@ApiModel(description = "经营策略模块DTO")
public class StrategyBillModuleDto extends BaseEntityDto {
    private static final long serialVersionUID = -61577576454686207L;
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 模块
     */
    @ApiModelProperty(value = "模块")
    private String module;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

}
