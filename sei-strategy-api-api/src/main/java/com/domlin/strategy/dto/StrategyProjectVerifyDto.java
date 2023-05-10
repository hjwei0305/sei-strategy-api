package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 验证问题(StrategyProjectVerify)DTO类
 *
 * @author sei
 * @since 2023-05-09 15:13:29
 */
@ApiModel(description = "验证问题DTO")
public class StrategyProjectVerifyDto extends BaseEntityDto {
    private static final long serialVersionUID = 146246799033405075L;
    /**
     * 确认结果
     */
    @ApiModelProperty(value = "确认结果")
    private String verifyResult;
    /**
     * 确认类别
     */
    @ApiModelProperty(value = "确认类别")
    private String verifyStyle;
    /**
     * 问题点
     */
    @ApiModelProperty(value = "问题点")
    private String verifyPoint;


    public String getVerifyResult() {
        return verifyResult;
    }

    public void setVerifyResult(String verifyResult) {
        this.verifyResult = verifyResult;
    }

    public String getVerifyStyle() {
        return verifyStyle;
    }

    public void setVerifyStyle(String verifyStyle) {
        this.verifyStyle = verifyStyle;
    }

    public String getVerifyPoint() {
        return verifyPoint;
    }

    public void setVerifyPoint(String verifyPoint) {
        this.verifyPoint = verifyPoint;
    }

}
