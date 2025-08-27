package com.dream.product.service.impl;
import java.math.BigDecimal;

import com.dream.product.bean.Product;
import com.dream.product.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @Author huzejun
 * @Date 2025-08-26 11:49
 **/

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("99"));
        product.setProductName("苹果-"+productId);
        product.setNum(2);


        return product;
    }
}
