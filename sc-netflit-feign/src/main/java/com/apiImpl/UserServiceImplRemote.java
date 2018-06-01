package com.apiImpl;

import com.entity.Result;
import com.hystrix.UserServiceFallbackFactory;
import com.interceptor.MyInterceptor;
import com.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/5/2.
 * Title UserServiceApiImpl
 * Package  com.apiImpl
 * Description
 *
 * @Version V1.0
 */
@FeignClient(value = "sc-service-provider",fallbackFactory = UserServiceFallbackFactory.class) //绑定服务名
public interface UserServiceImplRemote{
    @RequestMapping(value = "/sayHello" ,method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name);

    @RequestMapping(value = "/findUserByName" ,method = RequestMethod.GET)
    public Result findUserByName(@RequestParam("username")String username , @RequestParam("pageCount") int pageCount
            , @RequestParam("pageSize") int pageSize);
}
