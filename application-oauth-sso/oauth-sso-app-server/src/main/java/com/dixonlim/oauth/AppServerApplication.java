package com.dixonlim.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Auther: DixonLim
 * @Date: 2020/6/22 03:37
 * @Description: Oauth2.0 App Server
 */
@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
public class AppServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppServerApplication.class, args);
    }
}
