package com.zk.microservicecustomer.service.impl;

import com.zk.microservicecustomer.config.FeignClientFallBack;
import com.zk.microservicecustomer.entry.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-provider",fallback = FeignClientFallBack.class )
public interface UserFeignClient {

    /**
     * 根据名称获取密码
     *
     * @return
     */
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    String getUser(@RequestParam("userName") String userName);

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    String addUser(@RequestBody User user);
}
