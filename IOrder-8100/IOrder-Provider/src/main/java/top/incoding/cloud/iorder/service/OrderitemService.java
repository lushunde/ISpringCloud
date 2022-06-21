package top.incoding.cloud.iorder.service;


import top.incoding.cloud.iorder.api.dto.Orderitem;

import java.util.List;

/**
* @author bellus
* @description 针对表【OrderItem】的数据库操作Service
* @createDate 2022-06-20 09:03:01
*/
public interface OrderitemService  {

    List<Orderitem> queryOrderitemList(String orderId);
}
