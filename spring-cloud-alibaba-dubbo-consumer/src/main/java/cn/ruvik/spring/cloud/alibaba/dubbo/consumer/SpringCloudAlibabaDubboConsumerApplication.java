package cn.ruvik.spring.cloud.alibaba.dubbo.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class SpringCloudAlibabaDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaDubboConsumerApplication.class, args);
    }
}
