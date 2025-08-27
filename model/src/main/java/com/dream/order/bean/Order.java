package com.dream.order.bean;

import com.dream.product.bean.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author huzejun
 * @Date 2025-08-26 12:12
 **/

@Data
public class Order {
    private Long id;
    private BigDecimal totalAmount;
    private Long UserId;
    private String nickName;
    private String address;
    private List<Product> productList;
}
