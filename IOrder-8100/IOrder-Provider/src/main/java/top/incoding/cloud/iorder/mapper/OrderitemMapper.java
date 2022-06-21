package top.incoding.cloud.iorder.mapper;


import org.apache.ibatis.annotations.Mapper;
import top.incoding.cloud.iorder.api.dto.Orderitem;

import java.util.List;

/**
* @author bellus
* @description 针对表【OrderItem】的数据库操作Mapper
* @createDate 2022-06-20 09:03:01
* @Entity iuser.top.incoding.cloud.Orderitem
*/
@Mapper
public interface OrderitemMapper {

    List<Orderitem> queryOrderitemList(String orderId);
}




