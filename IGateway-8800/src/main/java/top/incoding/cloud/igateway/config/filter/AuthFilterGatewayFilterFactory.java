package top.incoding.cloud.igateway.config.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.incoding.cloud.constant.Constants;
import top.incoding.cloud.constant.ExceptionEnum;
import top.incoding.cloud.exception.BusinException;
import top.incoding.cloud.iuser.api.client.IUserFeignClient;
import top.incoding.cloud.result.R;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName AuthFilter
 * @Description 实现全局的过滤器，不需要添加
 * @Author bellus
 * @Date 2022/6/20 21:13
 * @Version 1.0.0
 **/


@Component
@Slf4j
public class AuthFilterGatewayFilterFactory implements GlobalFilter , Ordered {


    @Value("#{'${auth.ignoreUrls}'.split(',')}")
    private List<String> ignoreUrls;


    @Autowired
    private IUserFeignClient iUserFeignClient;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        log.info("=============全局过滤器执行 path={}",path);
        System.err.println("=============全局过滤器执行 path="+path);
        if(StringUtils.hasText(path) && ignoreUrls.contains(path) ){
            return chain.filter(exchange);
        }

        // 校验
        String token = request.getHeaders().getFirst(Constants.TOKEN);
        if(StringUtils.hasText(token)){

           // R<String> result = iUserFeignClient.validateToken(token);

            // 使用异步方式请求，否则出异常 block()/blockFirst()/blockLast() are blocking, which is not supported in thread reactor-http-nio-2 	at reactor.core.publisher.BlockingSingleSubscriber.blockingGet(BlockingSingleSubscriber.java:83)
            CompletableFuture<R<String>> future = CompletableFuture.supplyAsync(() -> iUserFeignClient.validateToken(token));
            R<String> result = null;
            try {
                result = future.get(1, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }


            if(result.getResult().equals(1)){


                System.err.println("=============全局过滤器执行 authOK=");
                ServerHttpRequest shr=request.mutate().header("uid",result.getData()).build();
                return chain.filter(exchange.mutate().request(shr).build());
            }

        }
        System.err.println("=============全局过滤器执行 authError=");
        return onError(exchange);

    }





    /**
     * @Description  异常返回信息
     * @author Liu_gx
     * @date 2021/1/8 17:29
     * @param exchange
     * @param rd
     * @return
     */
    private Mono<Void> onError(ServerWebExchange exchange){
        ServerHttpResponse response=exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        response.getHeaders().add("Content-Type","application/json;charset=UTF-8");
        R result = R.error(BusinException.newInstance(ExceptionEnum.UNAUTHORIZED));
        ObjectMapper objectMapper=new ObjectMapper();
        String rs="";
        try {
            rs=objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            log.error("occur Exception:"+e);
        }
        DataBuffer buffer= response.bufferFactory().wrap(rs.getBytes());
        return response.writeWith(Flux.just(buffer));
    }




    @Override
    public int getOrder() {
        return 0;
    }
}
