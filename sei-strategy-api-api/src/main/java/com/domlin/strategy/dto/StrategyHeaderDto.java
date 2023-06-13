package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 实现功能：
 *
 * @author 作者[wake]
 * @version 1.0.00 2023-06-10 16:55
 */
public class StrategyHeaderDto  extends BaseEntityDto {

    //创建一个strategyAnalyzeBillDto的集合
    @ApiModelProperty("strategyAnalyzeBillDto")
    private StrategyAnalyzeBillDto strategyAnalyzeBillDto;

    /**
     * 策略负责人
     */
    @ApiModelProperty("策略负责人")
    private List<StrategyUserDto> offcers;

    /**
     * 策略管理员
     */
    @ApiModelProperty("策略管理员")
    private List<StrategyUserDto> managers;

    /**
     * 策略联系人
     */
    @ApiModelProperty("策略联系人")
    private List<StrategyUserDto> contacts;

    /**
     * 单位负责人
     */
    @ApiModelProperty("单位负责人")
    private List<StrategyUserDto> unitManagers;

    public StrategyAnalyzeBillDto getStrategyAnalyzeBillDto() {
        return strategyAnalyzeBillDto;
    }

    public void setStrategyAnalyzeBillDto(StrategyAnalyzeBillDto strategyAnalyzeBillDto) {
        this.strategyAnalyzeBillDto = strategyAnalyzeBillDto;
    }

    public List<StrategyUserDto> getOffcers() {
        return offcers;
    }

    public void setOffcers(List<StrategyUserDto> offcers) {
        this.offcers = offcers;
    }

    public List<StrategyUserDto> getManagers() {
        return managers;
    }

    public void setManagers(List<StrategyUserDto> managers) {
        this.managers = managers;
    }

    public List<StrategyUserDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<StrategyUserDto> contacts) {
        this.contacts = contacts;
    }

    public List<StrategyUserDto> getUnitManagers() {
        return unitManagers;
    }

    public void setUnitManagers(List<StrategyUserDto> unitManagers) {
        this.unitManagers = unitManagers;
    }
}
