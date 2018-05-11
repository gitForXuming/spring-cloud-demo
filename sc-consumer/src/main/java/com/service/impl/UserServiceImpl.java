package com.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by lenovo on 2018/4/29.
 * Title UserServiceImpl
 * Package  com.service.impl
 * Description
 *
 * @Version V1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "userServiceFallback")
    @Override
    public String sayHello(String name) {
        List<ServiceInstance> list = discoveryClient.getInstances("sc-service-provider");
        if(list.size()!=0){
            System.out.println(list.get(0).getUri());
        }
        String result="";
        String url = "http://"+ "sc-service-provider"+"/sayHello?name=xuming";
        System.out.println(url);
        result = restTemplate.getForObject(url,String.class);
        return result;
    }

    public String userServiceFallback(String name){
        return "service remote invoken fail";
    }
}
