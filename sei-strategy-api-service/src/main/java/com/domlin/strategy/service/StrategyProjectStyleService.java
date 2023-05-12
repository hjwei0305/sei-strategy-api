package com.domlin.strategy.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseEntityDao;
import com.changhong.sei.core.dto.ResultData;
import com.changhong.sei.core.service.BaseEntityService;
import com.domlin.strategy.dao.StrategyProjectStyleDao;
import com.domlin.strategy.entity.StrategyProjectStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 项目类别(StrategyProjectStyle)业务逻辑实现类
 *
 * @author sei
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
     * @param projectStyleList
     * @throws IOException
     */
    @Transactional(rollbackFor = Exception.class)
    public void uploadStrategyProjectStyle(List<StrategyProjectStyle> projectStyleList) {
        if (projectStyleList.size() > 0) {
            save(projectStyleList);
        } else {
            throw new RuntimeException("导入数据不能为空");
        }
    }
}
