package com.zk.microservicecustomer.dao;

import lombok.Data;

@Data
public class UserResp {

    private int id;
    private String userName;
    private String userPassword;
}
