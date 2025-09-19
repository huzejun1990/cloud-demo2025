package com.dream.order.feign;

import com.dream.order.feign.fallback.ProductFeignClientFallback;
import com.dream.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author huzejun
 * @Date 2025-09-04 17:06
 **/

@FeignClient(value = "service-product",fallback = ProductFeignClientFallback.class)    //feign客户端
//@FeignClient(value = "gateway",fallback = ProductFeignClientFallback.class)    //feign客户端
public interface ProductFeignClient {

    //mvc注解的两套使用罗罗
    //1.标注在Controller上,是接受这样的请求
    //2.标注在FeignClient上,是发送这样的请求
//    @GetMapping("/api/product/product/{id}")
    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable("id") Long id);

}
