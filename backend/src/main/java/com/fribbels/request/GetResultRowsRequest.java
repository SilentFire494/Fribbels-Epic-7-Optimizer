package com.fribbels.request;

import com.fribbels.enums.OptimizationColumn;
import com.fribbels.enums.SortOrder;
import com.fribbels.model.Request;

public class GetResultRowsRequest extends Request {

    private String executionId;
    private int startRow;
    private int endRow;
    private OptimizationColumn sortColumn;
    private SortOrder sortOrder;
    private OptimizationRequest optimizationRequest;

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public OptimizationColumn getSortColumn() {
        return sortColumn;
    }

    public void setSortColumn(OptimizationColumn sortColumn) {
        this.sortColumn = sortColumn;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public OptimizationRequest getOptimizationRequest() {
        return optimizationRequest;
    }

    public void setOptimizationRequest(OptimizationRequest optimizationRequest) {
        this.optimizationRequest = optimizationRequest;
    }

    @Override
    public String toString() {
        return "GetResultRowsRequest [executionId=" + executionId + ", startRow=" + startRow + ", endRow=" + endRow
                + ", sortColumn=" + sortColumn + ", sortOrder=" + sortOrder + ", optimizationRequest="
                + optimizationRequest + "]";
    }

}
