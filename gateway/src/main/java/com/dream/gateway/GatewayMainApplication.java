package com.dream.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author huzejun
 * @Date 2025-09-15 14:50
 **/

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMainApplication.class, args);
    }
}
