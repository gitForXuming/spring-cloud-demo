package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = "com")
@MapperScan("com.mapper")
public class ScServiceProviderTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScServiceProviderTwoApplication.class, args);
	}
}
