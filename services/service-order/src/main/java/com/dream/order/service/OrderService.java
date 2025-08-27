package com.dream.order.service;

import com.dream.order.bean.Order;

/**
 * @Author huzejun
 * @Date 2025-08-26 12:15
 **/
public interface OrderService {

    Order createOrder(Long productId, Long userId);
}
