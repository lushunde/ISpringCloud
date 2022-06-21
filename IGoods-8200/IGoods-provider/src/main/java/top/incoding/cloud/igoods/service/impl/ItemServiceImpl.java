package top.incoding.cloud.igoods.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.incoding.cloud.igoods.mapper.ItemMapper;
import top.incoding.cloud.igoods.api.dto.Item;
import top.incoding.cloud.igoods.service.ItemService;

import java.util.List;

/**
* @author bellus
* @description 针对表【item】的数据库操作Service实现
* @createDate 2022-06-20 12:29:19
*/
@Service
public class ItemServiceImpl     implements ItemService {


    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> queryGoodsList(Long id) {
        return itemMapper.queryGoodsList(id);
    }
}




