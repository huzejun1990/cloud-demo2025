package com.dream.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author huzejun
 * @Date 2025-08-26 14:28
 **/

@Configuration
public class OrderConfig {

    @LoadBalanced   //注解式负载均衡
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
