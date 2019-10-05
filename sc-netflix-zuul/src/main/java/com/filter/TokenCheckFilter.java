package com.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * Created by lenovo on 2018/5/11.
 * Title TokenCheckFilter
 * Package  com.filter
 * Description
 *
 * @Version V1.0
 */
public class TokenCheckFilter  extends ZuulFilter{
    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}
