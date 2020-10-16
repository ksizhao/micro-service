package cn.ruvik.spring.cloud.alibaba.dubbo.gateway;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo
public class SpringCloudAlibabaDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaDubboProviderApplication.class, args);
    }

}
