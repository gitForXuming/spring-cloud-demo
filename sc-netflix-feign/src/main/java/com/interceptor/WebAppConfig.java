package com.interceptor;

import com.apiImpl.UserServiceImplRemote;
import com.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2018/5/25.
 * Title WebAppConfig
 * Package  com.interceptor
 * Description
 * public class WebAppConfig implements WebMvcConfigurer {
 * @Version V1.0
 */

public class WebAppConfig extends WebMvcConfigurationSupport {
    //spring boot 启动时会通过@Autowired 将所有继承WebMvcConfigurationSupport 的类都注册到拦截器集合里面
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");//.excludePathPatterns(Arrays.asList("/js/**","/css/**"));
    }

    /**
     *  配置静态文件不被拦截器拦截
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/static/image/");
        registry.addResourceHandler("/doc/**").addResourceLocations("classpath:/static/doc/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");

        registry.addResourceHandler("/**").addResourceLocations("webjars/");


    }


}
