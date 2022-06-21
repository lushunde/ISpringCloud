package top.incoding.cloud.iorder.mapper;


import org.apache.ibatis.annotations.Mapper;
import top.incoding.cloud.iorder.api.dto.Order;

import java.util.List;

/**
* @author bellus
* @description 针对表【Order】的数据库操作Mapper
* @createDate 2022-06-20 09:03:01
* @Entity iuser.top.incoding.cloud.Order
*/
@Mapper
public interface OrderMapper  {

    List<Order> queryOrderList(Long userId);
}




