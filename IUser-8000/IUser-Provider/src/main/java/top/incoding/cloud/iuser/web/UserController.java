package top.incoding.cloud.iuser.web;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.incoding.cloud.constant.ExceptionEnum;
import top.incoding.cloud.exception.BusinException;
import top.incoding.cloud.iorder.api.client.IOrderFeignClient;
import top.incoding.cloud.iorder.api.dto.Order;
import top.incoding.cloud.iuser.api.dto.AuthLoginUser;
import top.incoding.cloud.iuser.api.dto.User;
import top.incoding.cloud.iuser.service.UserService;
import top.incoding.cloud.jwt.JwtGeneratorUtil;
import top.incoding.cloud.result.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/19 17:08
 * @Version 1.0.0
 **/

@RestController
@RequestMapping("/api/")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private IOrderFeignClient iOrderFeignClient;



    @PostMapping(value = "login")
    public R<String> login( @RequestBody AuthLoginUser loginUser){
        User user = userService.getUserByUserName(loginUser.getUserName());

        if(user!=null &&  user.getPassword().equals(loginUser.getPassword()) ){
            Map<String,Object> payLoad=new HashMap<>(2);
            payLoad.put("uid",user.getUserId());
            payLoad.put("exp", DateTime.now().plusHours(1).toDate().getTime()/1000);
            String token= JwtGeneratorUtil.generatorToken(payLoad);

            return  R.ok("登陆成功").data(token);
        }else{
            return R.error(BusinException.newInstance(ExceptionEnum.UNAUTHORIZED));
        }


    }


    @GetMapping("getListByUserId/{userId}")
    public R<List<Order>> queryOrderList(@PathVariable("userId") Long userId) {
       return  iOrderFeignClient.queryOrderList(userId);

    }




}
