package com.wz.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class LoginServerApplication {
    public static void main(String arg[]){
        SpringApplication.run(LoginServerApplication.class,arg);
    }
}
