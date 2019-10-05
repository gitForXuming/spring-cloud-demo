package com.controller;


import org.springframework.beans.factory.annotation.Value;

/**
 * Created by lenovo on 2018/4/26.
 * Title BaseController
 * Package  com.controller
 * Description
 *
 * @Version V1.0
 */
public class BaseController {
    @Value("${server.servlet.context-path}")
    private String contextPath ="/demo";

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }
}
