package top.incoding.cloud.iorder.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.incoding.cloud.iorder.mapper.OrderMapper;
import top.incoding.cloud.iorder.api.dto.Order;
import top.incoding.cloud.iorder.api.dto.Orderitem;
import top.incoding.cloud.iorder.service.OrderService;
import top.incoding.cloud.iorder.service.OrderitemService;

import java.util.List;

/**
* @author bellus
* @description 针对表【Order】的数据库操作Service实现
* @createDate 2022-06-20 09:03:01
*/
@Service
public class OrderServiceImpl     implements OrderService {


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderitemService orderitemService;

    @Override
    public List<Order> queryOrderList(Long userId) {
        List<Order> orders = orderMapper.queryOrderList(userId);
        if(orders == null || orders.size() == 0){
            for (Order order : orders) {
                List<Orderitem> orderItems = this.orderitemService.queryOrderitemList(order.getOrderId());
                if(orderItems != null){
                    order.setOrderItems(orderItems);
                }

            }
        }

        return orders;

    }
}




