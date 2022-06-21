package top.incoding.cloud.iorder.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.incoding.cloud.iorder.mapper.OrderitemMapper;
import top.incoding.cloud.iorder.api.dto.Orderitem;
import top.incoding.cloud.iorder.service.OrderitemService;

import java.util.List;

/**
* @author bellus
* @description 针对表【OrderItem】的数据库操作Service实现
* @createDate 2022-06-20 09:03:01
*/
@Service
public class OrderitemServiceImpl   implements OrderitemService {


    @Autowired
    private OrderitemMapper orderitemMapper;

    @Override
    public List<Orderitem> queryOrderitemList(String orderId) {
        return orderitemMapper.queryOrderitemList(orderId);
    }
}




