package top.incoding.cloud.igoods.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.incoding.cloud.igoods.api.dto.Item;
import top.incoding.cloud.result.R;

import java.util.List;

/**
 * @ClassName IGoodsFeignClient
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/20 16:55
 * @Version 1.0.0
 **/

@FeignClient("goods-service")
public interface IGoodsFeignClient {


    @GetMapping(value = "getItemById/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public R<List<Item>> queryGoodsList(@PathVariable("id") Long id) ;

}
