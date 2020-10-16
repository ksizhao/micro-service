package cn.ruvik.spring.cloud.alibaba.dubbo.consumer;

import cn.ruvik.spring.cloud.alibaba.dubbo.api.DubboApi;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudAlibabaDubboConsumerApplicationTests {

    @Reference(check = false)
    private DubboApi dubboApi;

    @Test
    public void contextLoads() {
        System.out.println(dubboApi.demo());
    }

}
