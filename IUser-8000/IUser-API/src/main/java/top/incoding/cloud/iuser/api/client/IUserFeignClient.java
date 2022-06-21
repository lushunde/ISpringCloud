package top.incoding.cloud.iuser.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import top.incoding.cloud.exception.BusinException;
import top.incoding.cloud.iuser.api.dto.AuthLoginUser;
import top.incoding.cloud.result.R;


/**
 * @ClassName IUserFeignClient
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/20 16:22
 * @Version 1.0.0
 **/


@FeignClient("user-service")
public interface IUserFeignClient {

    /**
     * @Description 不要太懒了注释一下吧^_^
     * @Author Bellus
     * @Date 2022/6/20 16:45
     * @Version 1.0.0
     * @Param [loginUser]
     * @return top.incoding.cloud.result.R<java.lang.String>
     **/
    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    R<String> login(@RequestBody AuthLoginUser loginUser);

    
    /**
     * @Description 不要太懒了注释一下吧^_^
     * @Author Bellus
     * @Date 2022/6/20 21:57
     * @Version 1.0.0
     * @Param [token]
     * @return top.incoding.cloud.result.R<java.lang.String>
     **/
    @GetMapping(value = "/validateToken",consumes = MediaType.APPLICATION_JSON_VALUE)
    R<String> validateToken(@RequestParam("token")String token);
}
