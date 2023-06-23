package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

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

    //用来处理多个经营策略对应一个项目的情况
    @ApiModelProperty("仅用于展示的strategyProjectDto")
    private StrategyProjectDto strategyProjectDto;

    //专门存放经营策略Code的集合
    @ApiModelProperty("strategyAnalyzeBillDto的code集合")
    private List<Map<String,String>> strategyCodes;

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
    @ApiModelProperty("模块对接人")
    private List<StrategyUserDto> contacts;

    /**
     * 单位负责人
     */
    @ApiModelProperty("单位负责人")
    private List<StrategyUserDto> unitManagers;

    /**
     * 模块
     */
    @ApiModelProperty("模块")
    private String modules;

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

    public StrategyProjectDto getStrategyProjectDto() {
        return strategyProjectDto;
    }

    public void setStrategyProjectDto(StrategyProjectDto strategyProjectDto) {
        this.strategyProjectDto = strategyProjectDto;
    }

    public List<Map<String, String>> getStrategyCodes() {
        return strategyCodes;
    }

    public void setStrategyCodes(List<Map<String, String>> strategyCodes) {
        this.strategyCodes = strategyCodes;
    }

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules;
    }
}
