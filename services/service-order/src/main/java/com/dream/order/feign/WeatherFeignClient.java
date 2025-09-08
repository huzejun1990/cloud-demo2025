package com.dream.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author huzejun
 * @Date 2025-09-08 13:50
 **/

// /whaip/json/alicityweather/condition
//@FeignClient(value = "weather-client",url = "http://aliv18.data.moji.com")
@FeignClient(value = "weather-client", url = "https://ali-weather.showapi.com")
public interface WeatherFeignClient {

/*    @PostMapping("/whapi/json/alicityweather/condition")
    String getWeather(@RequestHeader("Authorization") String auth,
                    @RequestParam("token") String token,
                    @RequestParam("cityId") String cityId)*/;

    @GetMapping("/weatherhistory")
    String getWeather(@RequestParam("areCode") String areaCode,
                      @RequestParam("area") String area,
                      @RequestParam("month") String month,
                      @RequestParam("startDate") String startDate,
                      @RequestParam("endDate") String endDate,
                      @RequestHeader("Authorization") String appCode);
}
