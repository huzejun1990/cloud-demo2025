package com.dream.order.service.impl;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.dream.order.bean.Order;
import com.dream.order.service.OrderService;
import com.dream.product.bean.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author huzejun
 * @Date 2025-08-26 12:21
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Order createOrder(Long productId, Long userId) {
        Product product = getProductFromRemoteWithLoadBalanceAnnotation(productId); //getProductFromRemoteWithLoadBalance
//        Product product = getProductFromRemote(productId); //getProductFromRemoteWithLoadBalance
        Order order = new Order();
        order.setId(1L);
        //TODO 总金额
        ;
        order.setTotalAmount(product.getPrice().multiply(new BigDecimal(product.getNum())));
        order.setUserId(userId);
        order.setNickName("zhangsan");
        order.setAddress("新学习");
        //TODO 远程查询商品列表
        order.setProductList(Arrays.asList(product));

        return order;
    }

    //进阶3：基于注解的负载均衡
    private Product getProductFromRemoteWithLoadBalanceAnnotation(Long productId){
        //2、给远程发送请求
        String url = "http://service-product/product/"+productId;
        //2.给远程发送请求： service-product 会被动态替换
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }

    //进阶2：完成负载均衡发送请求
    private Product getProductFromRemoteWithLoadBalance(Long productId){
        //1.获取到商品服务所在的所有机器IP+port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        ServiceInstance instance = instances.get(0);
        // 远程URL
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;
        log.info("远程请求：{}",url);
        //2.给远程发送请求
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }


    private Product getProductFromRemote(Long productId){
        //1.获取到商品服务所在的所有机器IP+port
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        ServiceInstance instance = instances.get(0);
        // 远程URL
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/" + productId;
        log.info("远程请求：{}",url);
        //2.给远程发送请求
        Product product = restTemplate.getForObject(url, Product.class);
        return product;
    }
}
