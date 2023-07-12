package com.domlin.strategy.flow;

import com.changhong.sei.core.dto.flow.FlowHistory;
import com.changhong.sei.core.dto.flow.FlowInstance;
import com.changhong.sei.core.dto.flow.FlowTask;

import java.io.Serializable;
import java.util.List;

/**
 * @author Joe
 * @date 2022/12/27
 */
public class ProcessTrackVO implements Serializable {

    private FlowInstance flowInstance;
    private List<FlowHistory> flowHistoryList;
    private List<FlowTask> flowTaskList;

    public FlowInstance getFlowInstance() {
        return flowInstance;
    }

    public void setFlowInstance(FlowInstance flowInstance) {
        this.flowInstance = flowInstance;
    }

    public List<FlowHistory> getFlowHistoryList() {
        return flowHistoryList;
    }

    public void setFlowHistoryList(List<FlowHistory> flowHistoryList) {
        this.flowHistoryList = flowHistoryList;
    }

    public List<FlowTask> getFlowTaskList() {
        return flowTaskList;
    }

    public void setFlowTaskList(List<FlowTask> flowTaskList) {
        this.flowTaskList = flowTaskList;
    }
}
