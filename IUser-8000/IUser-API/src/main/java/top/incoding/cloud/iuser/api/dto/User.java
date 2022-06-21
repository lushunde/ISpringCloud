package top.incoding.cloud.iuser.api.dto;

import java.io.Serializable;

/**
 * 
 * @TableName User
 */
public class User implements Serializable {
    /**
     * 用户主键
     */
    private Long userId;

    /**
     * 登陆名
     */
    private String userName;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 昵称
     */
    private String realName;

    /**
     * 性别 1-男   2-女
     */
    private Integer sex;

    /**
     * 头像URL
     */
    private String img;

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户主键
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 登陆名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 登陆名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 登陆密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 登陆密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 昵称
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 昵称
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 性别 1-男   2-女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别 1-男   2-女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 头像URL
     */
    public String getImg() {
        return img;
    }

    /**
     * 头像URL
     */
    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", realName=").append(realName);
        sb.append(", sex=").append(sex);
        sb.append(", img=").append(img);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}