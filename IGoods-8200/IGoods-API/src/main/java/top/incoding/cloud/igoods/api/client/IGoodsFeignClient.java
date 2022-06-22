package top.incoding.cloud.igoods.api.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.incoding.cloud.constant.ExceptionEnum;
import top.incoding.cloud.exception.BusinException;
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


@FeignClient(value = "goods-service")
public interface IGoodsFeignClient {


    /**
     * @Description 不要太懒了注释一下吧^_^
     * @Author Bellus
     * @Date 2022/6/22 10:09 
     * @Version 1.0.0
     * @Param [id]
     * @return top.incoding.cloud.result.R<java.util.List<top.incoding.cloud.igoods.api.dto.Item>>
     **/
    @GetMapping(value = "getItemById/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public R<List<Item>> queryGoodsList(@PathVariable("id") Long id) throws BusinException;




}
