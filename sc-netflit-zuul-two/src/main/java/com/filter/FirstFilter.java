package com.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by lenovo on 2018/4/30.
 * Title FirstFilter
 * Package  com.filter
 * Description
 *
 * @Version V1.0
 */
@Component
public class FirstFilter extends ZuulFilter {
    @Override
    public String filterType() {
            return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        HttpSession session = request.getSession();
        String sessionId = session.getId();

        System.out.println("zuul session id: " + session.getId());
        context.addZuulRequestHeader("sessionID",sessionId);//将sessionid 传给下一个服务
        context.setSendZuulResponse(true);// 对该请求进行路由
        context.setResponseStatusCode(200); // 返回200正确响应
        return null;
    }
}
