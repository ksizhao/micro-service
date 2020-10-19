package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.service;

import cn.ruvik.spring.cloud.alibaba.dubbo.gateway.config.NacosGatewayProperties;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月17日 16:01:00
 */
@Component
@Slf4j
public class DynamicRouteServiceImplByNacos {


    @Autowired
    private DynamicRouteServiceImpl dynamicRouteService;

    @Autowired
    private NacosGatewayProperties nacosGatewayProperties;



    @PostConstruct
    public void init(){
        dynamicRouteByNacosListener();
    }

    /**
     * 监听Nacos Server下发的动态路由配置
     */
    public void dynamicRouteByNacosListener (){
        try {
            ConfigService configService= NacosFactory.createConfigService(nacosGatewayProperties.getAddress());
            String content = configService.getConfig(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroupId(), nacosGatewayProperties.getTimeout());
            log.info("配置参数[{}]",content);
            configService.addListener(nacosGatewayProperties.getDataId(), nacosGatewayProperties.getGroupId(), new Listener()  {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    List<RouteDefinition> list = JSON.parseArray(configInfo, RouteDefinition.class);
                    list.forEach(definition->{
                        dynamicRouteService.update(definition);
                    });
                }
                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            e.printStackTrace();
        }
    }
}
