package com.zk.microservicecustomer.controller;


import com.zk.microservicecustomer.entry.User;
import com.zk.microservicecustomer.service.impl.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 消费类
 */
@RestController
public class CustomerController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient balancerClient;


    @Autowired
    private UserFeignClient userFeignClient;


    @GetMapping("/getUser")
    public String getPassword(String userName) {
        print();
        return restTemplate.getForObject("http://microservice-provider/getUser?" + userName, String.class);

    }


    @GetMapping("/getPasswordByName")
    public String getPasswordByName(String userName) {
        System.out.println("请求参数"+userName);
        return this.userFeignClient.getUser(userName);

    }

    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user) {
        print();
        return this.userFeignClient.addUser(user);
    }

    @GetMapping("/logInstance")
    public void logInstance() {
        print();
    }

    private void print() {
        ServiceInstance instance = this.balancerClient.choose("microservice-provider");
        System.out.println("当前实例:" + instance.getServiceId() + " 地址:" + instance.getHost() + " 端口：" + instance.getPort());
    }




}
