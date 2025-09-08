package com.dream.order;

import com.dream.order.feign.WeatherFeignClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author huzejun
 * @Date 2025-09-08 13:56
 **/

@SpringBootTest
public class WeatherTest {

    @Autowired
    WeatherFeignClient weatherFeignClient;

/*    @Test
    void test01(){
        String weather = weatherFeignClient.getWeather("APPCODE 93b7e19861a24c519a7548b17dc16d75",
                "50b53ff8dd7d9fa320d3d3ca32cf8ed1",
                "2182");
        System.out.println("weather = " + weather);
    }*/

    @Test
    public void testWeather() {
        String response = weatherFeignClient.getWeather("511025",
                "资中", "202509",
                "20250907", "20250908",
                "APPCODE " + "451413c94ad84fef98a46e61f41359c6");

        System.out.println(response);
    }
}
