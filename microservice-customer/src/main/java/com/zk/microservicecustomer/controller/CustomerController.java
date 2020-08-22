package com.zk.microservicecustomer.controller;

import com.zk.microservicecustomer.common.JsonResult;
import com.zk.microservicecustomer.dao.UserResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * 消费类
 */
@RestController
public class CustomerController {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient balancerClient;

    @GetMapping("/getUser")
    public String getPassword(String userName){
        print();
        return restTemplate.getForObject("http://microservice-provider/getUser?"+userName,String.class);

    }

    @GetMapping("/logInstance")
    public void logInstance(){
        print();
    }

    private void print() {
        ServiceInstance instance=this.balancerClient.choose("microservice-provider");
        System.out.println("当前实例:"+instance.getServiceId()+" 地址:"+instance.getHost()+" 端口："+instance.getPort());
    }




}
