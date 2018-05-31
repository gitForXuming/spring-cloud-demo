package com.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/5/2.
 * Title Result
 * Package  com.model
 * Description
 *
 * @Version V1.0
 */
public class Result {

    private Class resultType;
    private long totalCount;
    private long totalPage;
    private List content = new ArrayList();
    private String errorCode;
    private String errorMessage;

    public Class getResultType() {
        return resultType;
    }

    public void setResultType(Class resultType) {
        this.resultType = resultType;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public List getContent() {
        return content;
    }

    public void setContent(List content) {
        this.content = content;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
