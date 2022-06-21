package top.incoding.cloud.iorder.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.incoding.cloud.iorder.api.dto.Order;
import top.incoding.cloud.iorder.service.OrderService;
import top.incoding.cloud.result.R;

import java.util.List;

/**
 * @ClassName OrderController
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/20 9:11
 * @Version 1.0.0
 **/

@RestController
@RequestMapping("order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping("getListByUserId/{userId}")
    public R<List<Order>> queryOrderList(@PathVariable("userId") Long userId) {
        List<Order> orders = this.orderService.queryOrderList(userId);

        return R.ok().data(orders);

    }


}
