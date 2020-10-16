package cn.ruvik.spring.cloud.alibaba.dubbo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaDubboGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaDubboGatewayApplication.class, args);
    }

}
