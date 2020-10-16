package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.dubbo;

import cn.ruvik.spring.cloud.alibaba.dubbo.api.DubboApi;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ruvik
 * @date 2019/5/8
 */
@Service
public class DubboApiImpl implements DubboApi {

    @Value("${server.port}")
    private Integer port;

    @Override
    public String demo() {
        return "port= "+ port;
    }

}
