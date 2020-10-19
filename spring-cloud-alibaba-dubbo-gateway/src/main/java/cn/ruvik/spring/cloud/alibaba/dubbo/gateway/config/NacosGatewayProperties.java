package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月17日 16:00:00
 */
@Data
@ConfigurationProperties(prefix="nacos", ignoreUnknownFields = true)
@Configuration
public class NacosGatewayProperties {

    private String address;

    private String dataId;

    private String groupId;

    private Long timeout;
}
