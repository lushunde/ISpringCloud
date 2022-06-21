package top.incoding.cloud.iuser.mapper;


import org.apache.ibatis.annotations.Param;
import top.incoding.cloud.iuser.api.dto.User;

/**
* @author bellus
* @description 针对表【User】的数据库操作Mapper
* @createDate 2022-06-19 16:52:41
* @Entity top.incoding.cloud.iuser.api.dto.User
*/


public interface UserMapper  {

    User getUserByUserName(@Param("userName") String userName);

}




