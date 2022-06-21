package top.incoding.cloud.iuser.service;

import top.incoding.cloud.iuser.api.dto.User;

/**
* @author bellus
* @description 针对表【User】的数据库操作Service
* @createDate 2022-06-19 16:52:41
*/
public interface UserService {

    User getUserByUserName(String userName);
}
