package com.entity;

/**
 * Created by lenovo on 2018/5/2.
 * Title User
 * Package  com.model
 * Description
 *
 * @Version V1.0
 */
public class UserVO extends BaseVO{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
