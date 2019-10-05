package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by lenovo on 2019/10/4.
 * Title ScNetflixDashBoardApplication
 * Package  com
 * Description
 *
 * @Version V1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ScNetflixDashBoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScNetflixDashBoardApplication.class, args);
    }
}
