package com.zk.microservicecustomer.config;

import com.zk.microservicecustomer.entry.User;
import com.zk.microservicecustomer.service.impl.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallBack implements UserFeignClient {

    @Override
    public String getUser(String userName) {
        return "服务不可用，返回默认值：null";
    }

    @Override
    public String addUser(User user) {
        return null;
    }
}
