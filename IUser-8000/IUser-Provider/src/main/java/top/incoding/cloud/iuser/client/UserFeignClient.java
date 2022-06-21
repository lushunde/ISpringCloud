package top.incoding.cloud.iuser.client;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.incoding.cloud.constant.ExceptionEnum;
import top.incoding.cloud.exception.BusinException;
import top.incoding.cloud.iuser.api.dto.AuthLoginUser;
import top.incoding.cloud.iuser.api.dto.User;
import top.incoding.cloud.iuser.api.client.IUserFeignClient;
import top.incoding.cloud.iuser.service.UserService;
import top.incoding.cloud.jwt.JwtGeneratorUtil;
import top.incoding.cloud.result.R;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserFeignClient
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/20 16:39
 * @Version 1.0.0
 **/

@RestController
@Slf4j
public class UserFeignClient implements IUserFeignClient {


    @Autowired
    private UserService userService;


    @Override
    public R<String> login(@RequestBody AuthLoginUser loginUser) {
        User user = userService.getUserByUserName(loginUser.getUserName());

        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            Map<String, Object> payLoad = new HashMap<>(2);
            payLoad.put("uid", user.getUserId());
            payLoad.put("exp", DateTime.now().plusHours(1).toDate().getTime() / 1000);
            String token = JwtGeneratorUtil.generatorToken(payLoad);

            return R.ok("登陆成功").data(token);
        } else {
            return R.error(BusinException.newInstance(ExceptionEnum.UNAUTHORIZED));
        }


    }

    @Override
    public R<String> validateToken(String token)  {

        if(StringUtils.isBlank(token)){
            log.info("token不存在");
            return R.error(BusinException.newInstance(ExceptionEnum.UNAUTHORIZED));
        }
        try {
            Claims claims = JwtGeneratorUtil.parseToken(token);

            return R.ok("用户登陆验证通过").data(claims.get("uid").toString());
        }catch (ExpiredJwtException e){
    log.info("token已过期");
            return R.error(BusinException.newInstance(ExceptionEnum.UNAUTHORIZED));
        }catch (SignatureException e){
            log.info("token校验失败");
            return R.error(BusinException.newInstance(ExceptionEnum.UNAUTHORIZED));
        }
    }
}