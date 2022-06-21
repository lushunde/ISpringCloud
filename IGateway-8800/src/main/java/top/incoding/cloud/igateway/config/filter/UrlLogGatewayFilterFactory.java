package top.incoding.cloud.igateway.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @ClassName RequestHasTokenGatewayFilterFactory
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/21 12:47
 * @Version 1.0.0
 **/

@Slf4j
@Component
public class UrlLogGatewayFilterFactory extends AbstractGatewayFilterFactory{

    @Override
    public GatewayFilter apply(Object config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                // 获取请求路径
                URI uri = exchange.getRequest().getURI();
                log.info("=================自定义单独Yml配置拦截器 获取到请求路径：{}", uri.toString());
                System.err.println("=============AbstractGatewayFilterFactory过滤器执行 uri="+uri.toString());
                return chain.filter(exchange);
            }


        };
    }
}