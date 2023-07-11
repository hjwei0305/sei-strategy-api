package com.domlin.strategy.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.domlin.strategy.vo.StrategyAnalyzeBillDto;

/**
 * 实现功能：
 *
 * @author 作者[wake]
 * @version 1.0.00 2023-06-16 17:25
 */
public class ChangeHeaderDto extends BaseEntityDto {

    /**
     * 经营策略实体类
     */
    private StrategyAnalyzeBillDto strategyAnalyzeBillDto;


    /**
     * 项目变更实体类
     */
    private StrategyProjectChangeDto strategyProjectChangeDto;

    /**
     * 经营策略项目
     */
    private StrategyProjectDto strategyProjectDto;

    public StrategyAnalyzeBillDto getStrategyAnalyzeBillDto() {
        return strategyAnalyzeBillDto;
    }

    public void setStrategyAnalyzeBillDto(StrategyAnalyzeBillDto strategyAnalyzeBillDto) {
        this.strategyAnalyzeBillDto = strategyAnalyzeBillDto;
    }

    public StrategyProjectChangeDto getStrategyProjectChangeDto() {
        return strategyProjectChangeDto;
    }

    public void setStrategyProjectChangeDto(StrategyProjectChangeDto strategyProjectChangeDto) {
        this.strategyProjectChangeDto = strategyProjectChangeDto;
    }

    public StrategyProjectDto getStrategyProjectDto() {
        return strategyProjectDto;
    }

    public void setStrategyProjectDto(StrategyProjectDto strategyProjectDto) {
        this.strategyProjectDto = strategyProjectDto;
    }
}
