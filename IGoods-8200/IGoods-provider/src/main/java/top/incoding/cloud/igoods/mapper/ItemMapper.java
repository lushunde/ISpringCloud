package top.incoding.cloud.igoods.mapper;


import org.apache.ibatis.annotations.Mapper;
import top.incoding.cloud.igoods.api.dto.Item;

import java.util.List;

/**
* @author bellus
* @description 针对表【item】的数据库操作Mapper
* @createDate 2022-06-20 12:29:19
* @Entity top.incoding.cloud.igoods.api.dto.Item
*/

@Mapper
public interface ItemMapper  {

    List<Item> queryGoodsList(Long id);
}




