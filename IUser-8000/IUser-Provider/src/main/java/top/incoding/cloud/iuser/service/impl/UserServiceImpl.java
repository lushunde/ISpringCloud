package top.incoding.cloud.iuser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.incoding.cloud.iuser.api.dto.User;
import top.incoding.cloud.iuser.service.UserService;
import top.incoding.cloud.iuser.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author bellus
* @description 针对表【User】的数据库操作Service实现
* @createDate 2022-06-19 16:52:41
*/
@Service
public class UserServiceImpl   implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }
}




