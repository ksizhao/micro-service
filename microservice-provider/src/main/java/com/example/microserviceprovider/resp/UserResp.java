package com.example.microserviceprovider.resp;

import java.io.Serializable;

public class UserResp implements Serializable {

    private static final long serialVersionUID = -5648048001054282313L;
    private String userName;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
