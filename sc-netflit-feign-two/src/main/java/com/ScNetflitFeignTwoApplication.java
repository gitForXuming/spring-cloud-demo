package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.RedisFlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication(scanBasePackages = "com")
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=300 ,redisFlushMode = RedisFlushMode.IMMEDIATE ,redisNamespace="demo") //单位 秒 IMMEDIATE 立即刷新
public class ScNetflitFeignTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScNetflitFeignTwoApplication.class, args);
	}
}
