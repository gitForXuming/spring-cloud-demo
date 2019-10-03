package com.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lenovo on 2019/10/3.
 * Title ConfigBeans
 * Package  com.config
 * Description
 *
 * @Version V1.0
 */
@Configuration
public class ConfigBeans {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
