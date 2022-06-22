package top.incoding.cloud.igoods.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.incoding.cloud.igoods.mapper.ItemMapper;
import top.incoding.cloud.igoods.api.dto.Item;
import top.incoding.cloud.igoods.service.ItemService;

import java.util.List;
import java.util.Random;

/**
* @author bellus
* @description 针对表【item】的数据库操作Service实现
* @createDate 2022-06-20 12:29:19
*/
@Service
public class ItemServiceImpl     implements ItemService {

    Random random = new Random();
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> queryGoodsList(Long id) {


        int i = random.nextInt(10);
        System.err.println("随机数="+i);
        if(i%2==0){
            System.err.println("随机数双数，需要延时6秒，测试熔断");
            try {
                Thread.sleep(6000);

            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        return itemMapper.queryGoodsList(id);
    }
}




