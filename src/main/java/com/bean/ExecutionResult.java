package com.bean;

import java.util.List;

public class ExecutionResult {
    private Long executionTime;
    private List<String> resultExecution;

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public List<String> getResultExecution() {
        return resultExecution;
    }

    public void setResultExecution(List<String> resultExecution) {
        this.resultExecution = resultExecution;
    }

    @Override
    public String toString() {
        return "ExecutionResult{" +
                "executionTime=" + executionTime +
                ", resultExecution=" + resultExecution +
                '}';
    }
}
