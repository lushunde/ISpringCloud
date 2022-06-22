package top.incoding.cloud.iorder.api.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.incoding.cloud.iorder.api.dto.Order;
import top.incoding.cloud.result.R;

import java.util.List;

/**
 * @ClassName IOrderFeignClient
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/20 16:51
 * @Version 1.0.0
 **/

@FeignClient(value = "order-service",fallback = IOrderFeignClient.IOrderFeignClientFallback.class)
public interface IOrderFeignClient {

    @GetMapping(value = "/queryOrderList/{userId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public R<List<Order>> queryOrderList(@PathVariable("userId") Long userId) ;


    class IOrderFeignClientFallback implements IOrderFeignClient {

        @Override
        public R<List<Order>> queryOrderList(Long userId) {

            System.err.println("熔断进入了");
            return null;
        }
    }

}
