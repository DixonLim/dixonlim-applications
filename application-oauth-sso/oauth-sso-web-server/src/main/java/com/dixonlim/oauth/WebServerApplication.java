package com.dixonlim.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: DixonLim
 * @Date: 2020/6/22 04:10
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class WebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServerApplication.class, args);
    }
}
