package top.incoding.cloud.igoods.service;


import top.incoding.cloud.igoods.api.dto.Item;

import java.util.List;

/**
* @author bellus
* @description 针对表【item】的数据库操作Service
* @createDate 2022-06-20 12:29:19
*/
public interface ItemService  {

    List<Item> queryGoodsList(Long id);
}
