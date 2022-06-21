package top.incoding.cloud.igoods.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.incoding.cloud.igoods.api.client.IGoodsFeignClient;
import top.incoding.cloud.igoods.api.dto.Item;
import top.incoding.cloud.igoods.service.ItemService;
import top.incoding.cloud.result.R;

import java.util.List;

/**
 * @ClassName GoodsFeignClient
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/20 16:57
 * @Version 1.0.0
 **/
@RestController
public class GoodsFeignClient implements IGoodsFeignClient {

    @Autowired
    private ItemService itemService;

    @Override
    public R<List<Item>> queryGoodsList(Long id) {
        List<Item> items = this.itemService.queryGoodsList(id);

        return R.ok().data(items);

    }
}
