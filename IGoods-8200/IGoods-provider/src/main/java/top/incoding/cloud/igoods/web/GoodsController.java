package top.incoding.cloud.igoods.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.incoding.cloud.igoods.api.dto.Item;
import top.incoding.cloud.igoods.service.ItemService;
import top.incoding.cloud.result.R;

import java.util.List;

/**
 * @ClassName GoodsController
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/20 12:35
 * @Version 1.0.0
 **/


@RestController
@RequestMapping("goods")
public class GoodsController {


    @Autowired
    private ItemService itemService;

    @GetMapping("getItemById/{id}")
    public R<List<Item>> queryGoodsList(@PathVariable("id") Long id) {
        List<Item> items = this.itemService.queryGoodsList(id);

        return R.ok().data(items);

    }


}