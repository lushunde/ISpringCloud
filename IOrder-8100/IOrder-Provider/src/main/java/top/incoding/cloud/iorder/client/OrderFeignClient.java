package top.incoding.cloud.iorder.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.incoding.cloud.exception.BusinException;
import top.incoding.cloud.igoods.api.client.IGoodsFeignClient;
import top.incoding.cloud.igoods.api.dto.Item;
import top.incoding.cloud.iorder.api.client.IOrderFeignClient;
import top.incoding.cloud.iorder.api.dto.Order;
import top.incoding.cloud.iorder.service.OrderService;
import top.incoding.cloud.result.R;

import java.util.List;

/**
 * @ClassName OrderFeignClient
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/20 16:53
 * @Version 1.0.0
 **/

@RestController
public class OrderFeignClient implements IOrderFeignClient {

    @Autowired
    private OrderService orderService;

    @Autowired
    private IGoodsFeignClient iGoodsFeignClient;

    @Override
    @HystrixCommand(fallbackMethod = "queryOrderListFallback", commandProperties =
            {
                    // 熔断器在整个统计时间内是否开启的阀值
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    // 至少有3个请求才进行熔断错误比率计算
                    /**
                     * 设置在一个滚动窗口中，打开断路器的最少请求数。
                     比如：如果值是20，在一个窗口内（比如10秒），收到19个请求，即使这19个请求都失败了，断路器也不会打开。
                     */
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
                    //当出错率超过50%后熔断器启动
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    // 熔断器工作时间，超过这个时间，先放一个请求进去，成功的话就关闭熔断，失败就再等一段时间
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
                    // 统计滚动的时间窗口
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000")
            })
    public R<List<Order>> queryOrderList(Long userId) {
        List<Order> orders = this.orderService.queryOrderList(userId);

        orders.stream().forEach((x)->{


            try {

                // 模拟超时
                R<List<Item>> result = iGoodsFeignClient.queryGoodsList(Long.valueOf(x.getUniquekey()));

                System.err.println(result);
                if(result.getResult().equals(1)){
                    x.setGoods(result.getData());
                }
            } catch (BusinException e) {
                System.err.println(e);
            }


        });

        return R.ok().data(orders);
    }


    /**
     * @Description 熔断对应的fallback方法
     * @Author Bellus
     * @Date 2022/6/22 11:31
     * @Version 1.0.0
     * @Param [userId]
     * @return top.incoding.cloud.result.R<java.util.List<top.incoding.cloud.iorder.api.dto.Order>>
     **/
    public R<List<Order>> queryOrderListFallback(Long userId) {

        System.out.println("queryOrderListFallback熔断了");
        return R.ok().data("已经熔断了");
    }
}
