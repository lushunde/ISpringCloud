package top.incoding.cloud.iorder.service;


import top.incoding.cloud.iorder.api.dto.Order;

import java.util.List;

/**
* @author bellus
* @description 针对表【Order】的数据库操作Service
* @createDate 2022-06-20 09:03:01
*/
public interface OrderService  {

    List<Order> queryOrderList(Long userId);
}
