package com.dream.product.bean;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author huzejun
 * @Date 2025-08-26 11:45
 **/

@Data
public class Product {
    private Long id;
    private BigDecimal price;
    private String productName;
    private int num;

}
