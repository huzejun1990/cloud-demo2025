package com.dream.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dream.order.bean.Order;
import com.dream.order.properties.OrderProperties;
import com.dream.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huzejun
 * @Date 2025-08-26 12:11
 **/
@RequestMapping("/api/order")
@Slf4j
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
        return "order.timeout="+orderProperties.getTimeout()+": "+
                "order.auto-confirm="+orderProperties.getAutoConfirm()+": "+
                "order.db-url="+orderProperties.getDbUrl();
    }

    /**
     * 数据隔离 order.db-url=order_dev（正确写法）
     * order-db-url=order_dev（错误写法，看起来很接近，容易出错）
     * @return
     */

    @GetMapping("/config1")
    public String config1() {
        return "order timeout: " + orderProperties.getTimeout()
                + " auto-confirm: " + orderProperties.getAutoConfirm()
                + " db-url: " + orderProperties.getDbUrl();
    }

    //创建订单
    @GetMapping("/create")
    public Order createOrder(@RequestParam("productId") Long productId,
                             @RequestParam("userId") Long userId) {

        Order order = orderService.createOrder(productId, userId);
        return order;
    }

    @GetMapping("/seckill")
    @SentinelResource(value = "seckill-order",fallback = "seckillFallback")
    public Order seckill(@RequestParam(value = "userId",required = false) Long userId,
                         @RequestParam(value = "productId",defaultValue = "1000") Long productId) {

        Order order = orderService.createOrder(productId, userId);
        order.setId(Long.MAX_VALUE);
        return order;
    }

    public Order seckillFallback(Long productId, Long userId, Throwable exception) {
        System.out.println("seckillFallback...");
        Order order = new Order();
        order.setId(productId);
        order.setUserId(userId);
        order.setAddress("异常信息： "+exception.getClass());
        return order;
    }

    @GetMapping("/writeDb")
    public String writeDb() {
        return "writeDb success....";
    }

    @GetMapping("/readDb")
    public String readDb() {
        log.info("readDb...");
        return "readDb success....";
    }
}
