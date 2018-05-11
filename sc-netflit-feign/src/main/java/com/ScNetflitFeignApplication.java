package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com")
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class ScNetflitFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScNetflitFeignApplication.class, args);
	}
}
