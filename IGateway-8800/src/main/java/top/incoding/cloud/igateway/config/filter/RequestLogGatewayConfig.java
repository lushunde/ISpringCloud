package top.incoding.cloud.igateway.config.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RequestLogGatewayConfig
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/21 11:37
 * @Version 1.0.0
 **/


@Configuration
public class RequestLogGatewayConfig {

//    @Bean
//    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/goods/**")
//                        .filters(f -> f.filter(new RequestLogGatewayFilterFactory()))
//                        .uri("lb:goods-service")
//                )
//                .build();
//    }
}
