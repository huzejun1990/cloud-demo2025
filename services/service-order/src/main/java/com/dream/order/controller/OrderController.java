package com.dream.order.controller;

import com.dream.order.bean.Order;
import com.dream.order.properties.OrderProperties;
import com.dream.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huzejun
 * @Date 2025-08-26 12:11
 **/

//@RefreshScope //自动刷新
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
//
//    @Value("${order.timeout}")
//    String orderTimeout;
//    @Value("${order.auto-confirm}")
//    String orderAutoConfirm;

    @Autowired
    OrderProperties orderProperties;

    @GetMapping("/config")
    public String config() {
        return "order.timeout="+orderProperties.getTimeout()+",order.auto-confirm="+orderProperties.getAutoConfirm();
    }

    //创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam("productId") Long productId,
                             @RequestParam("userId") Long userId) {

        Order order = orderService.createOrder(productId, userId);
        return order;
    }
}
