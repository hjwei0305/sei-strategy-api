package com.domlin.strategy.service;

import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectStyleDao;
import com.domlin.strategy.entity.StrategyProjectStyle;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


/**
 * 项目类别(StrategyProjectStyle)业务逻辑实现类
 *
 * @author wake
 * @since 2023-05-09 15:13:27
 */
@Service
public class StrategyProjectStyleService extends BaseEntityService<StrategyProjectStyle> {
    @Autowired
    private StrategyProjectStyleDao dao;

    @Override
    protected BaseEntityDao<StrategyProjectStyle> getDao() {
        return dao;
    }

    public StrategyProjectStyle update(StrategyProjectStyle strategyProjectStyle) {
            return dao.save(strategyProjectStyle);
    }


    /**
     * 上传计划
     *
     * @param list
     * @throws IOException
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData<String> uploadStrategyProjectStyle(List<StrategyProjectStyle> list) {
        if(CollectionUtils.isNotEmpty(list)) {
            save(list);
        } else {
            throw new RuntimeException("导入数据不能为空");
        }
        return ResultData.success("导入成功");
    }
}
