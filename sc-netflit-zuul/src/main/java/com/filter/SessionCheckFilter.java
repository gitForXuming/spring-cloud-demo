package com.filter;

import com.base.Constant;
import com.entity.Result;
import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Created by lenovo on 2018/5/8.
 * Title SessionCheckFilter
 * Package  com.filter
 * Description
 *
 * @Version V1.0
 */
@Component
@RefreshScope // 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
public class SessionCheckFilter extends ZuulFilter{
    private static final Logger LOGGER = LoggerFactory.getLogger(SessionCheckFilter.class);

    @Value("${notCheckSessionUri}")
    private String notCheckSessionUri;

    @Value("${profile}")
    private String profile;
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 设置过滤器执行优先级 int值越小越早执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String path = request.getContextPath();
        String uri =request.getRequestURI();
        boolean isMatch =false;
        if(null!=notCheckSessionUri &&!"".equals(notCheckSessionUri)){
            String[] patterns =notCheckSessionUri.split(",");
            for(String pattern:patterns){
                isMatch = Pattern.matches(pattern,uri);
                if(isMatch){
                    break;
                }
            }
        }
        if(isMatch){
            return false;
        }
        return true;
    }
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpSession session = request.getSession();

        try{
            Object loogn = session.getAttribute("logon")==null?"0":session.getAttribute("logon").toString();
            if("1".equals(loogn)){
                session.setAttribute("invokenFlag","zuulOne");
                LOGGER.info("用户已经登录");
                context.setSendZuulResponse(true);// 对该请求进行路由
                context.setResponseStatusCode(200); // 返回200正确响应
            }else{
                String uri =request.getRequestURI();
                if(uri.contains("ajax")){
                    try {
                        //跳转到登录页面
                        context.setSendZuulResponse(false);//
                        context.setResponseStatusCode(200); // 返回200正确响应
                        context.getResponse().setHeader("content-type" ,"application/json;charset=utf-8");
                        Result result = new Result();
                        result.setErrorCode("0000");
                        result.setErrorMessage("会话超时");
                        Gson gosn = new Gson();
                        context.setResponseBody(gosn.toJson(result));
                    }catch (Exception e){

                    }
                }else{
                    try{
                        //跳转到登录页面
                        context.setSendZuulResponse(false);// 对该请求进行路由
                        context.setResponseStatusCode(200); // 返回200正确响应
                        context.getResponse().setHeader("content-type" ,"text/html;charset=UTF-8");
                        context.setResponseBody("操作非法，此操作必须先进行登录认证，点击<a href='/demo/index'>登录</a>");
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
