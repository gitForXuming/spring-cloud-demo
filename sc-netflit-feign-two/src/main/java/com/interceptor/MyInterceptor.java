package com.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lenovo on 2018/5/25.
 * Title MyInterceptor
 * Package  com.interceptor
 * Description
 *
 * @Version V1.0
 */
public class MyInterceptor  implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyInterceptor.class);

    private  static final ThreadLocal<Long> time = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return super.initialValue();
        }
    };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info(request.getRequestURI()+"请求处理开始时间："+System.currentTimeMillis());
        time.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        LOGGER.info(request.getRequestURI()+"请求处理结束时间："+Long.toString(System.currentTimeMillis()));
        LOGGER.info(request.getRequestURI()+"请求处理耗时："+Long.toString(System.currentTimeMillis()-time.get()));
        time.remove();
    }

}
