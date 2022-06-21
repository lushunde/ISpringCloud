package top.incoding.cloud.iuser.api.dto;


/**
 * @ClassName AuthLoginUser
 * @Description TODO 快来记录点什么吧，不要太懒了
 * @Author bellus
 * @Date 2022/6/19 18:01
 * @Version 1.0.0
 **/


public class AuthLoginUser {

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
