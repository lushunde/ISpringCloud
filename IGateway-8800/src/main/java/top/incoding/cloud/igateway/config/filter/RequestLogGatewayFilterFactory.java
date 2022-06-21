package top.incoding.cloud.igateway.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import top.incoding.cloud.constant.Constants;

/**
 * @ClassName RequestLog
 * @Description 实现自定义过滤器
 * @Author bellus
 * @Date 2022/6/21 11:33
 * @Version 1.0.0
 **/


@Component
@Slf4j
public class RequestLogGatewayFilterFactory implements GatewayFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst(Constants.TOKEN);
        log.info("=============================gateway 请求统一拦截日志：token={}",token);
        System.err.println("=============GatewayFilter过滤器执行 token="+token);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
