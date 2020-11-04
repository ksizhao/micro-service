package cn.ruvik.spring.cloud.alibaba.dubbo.consumer.controller;

import cn.ruvik.spring.cloud.alibaba.dubbo.api.DubboApi;
import cn.ruvik.spring.cloud.alibaba.dubbo.api.IdGenerateApi;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * consumer
 *
 * @author ruvik
 * @date 2019/5/8
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Reference(check = false)
    private DubboApi dubboApi;

    @Reference(check = false)
    private IdGenerateApi idGenerateApi;

    @GetMapping("/demo")
    public Object demo() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("spring-cloud-alibaba-dubbo-provider");
        String url = String.format("http://%s:%s/provider/demo", serviceInstance.getHost(), serviceInstance.getPort());
        System.out.println("request url:" + url);
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/dubbo")
    @SentinelResource(value = "test")
    public Object dubbo() {
        return dubboApi.demo();
    }


    @PostMapping("/getId")
    @SentinelResource(value = "getId",defaultFallback = "respFallback")
    public Object test() {
        return idGenerateApi.getId("");
    }


    public String respFallback(Throwable t){

        return "服务不可用，原因："+t.getClass().getCanonicalName();
    }

}
