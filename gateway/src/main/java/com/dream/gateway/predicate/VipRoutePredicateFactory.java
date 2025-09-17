package com.dream.gateway.predicate;

import com.alibaba.nacos.common.utils.StringUtils;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;
import java.util.function.Predicate;

/**
 * @Author huzejun
 * @Date 2025-09-17 19:27
 **/


@Component
public class VipRoutePredicateFactory extends AbstractRoutePredicateFactory<VipRoutePredicateFactory.Config> {


    public VipRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return List.of("param", "value");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return (GatewayPredicate) serverWebExchange -> {
            // localhost/search?q=haha&user=mofan
            ServerHttpRequest request = serverWebExchange.getRequest();
            String first = request.getQueryParams().getFirst(config.param);
            return StringUtils.hasText(first) && first.equals(config.value);
        };
    }



    @Validated
    @Getter
    @Setter
    public static class Config {
        @NotEmpty
        private String param;
        @NotEmpty
        private String value;
    }
}
