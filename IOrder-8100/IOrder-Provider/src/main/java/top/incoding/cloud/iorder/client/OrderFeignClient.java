package top.incoding.cloud.iorder.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
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
    public R<List<Order>> queryOrderList(Long userId) {
        List<Order> orders = this.orderService.queryOrderList(userId);

        orders.stream().forEach((x)->{

            R<List<Item>> result = iGoodsFeignClient.queryGoodsList(Long.valueOf(x.getUniquekey()));
            if(result.getResult().equals(1)){
                x.setGoods(result.getData());
            }

        });

        return R.ok().data(orders);
    }
}
