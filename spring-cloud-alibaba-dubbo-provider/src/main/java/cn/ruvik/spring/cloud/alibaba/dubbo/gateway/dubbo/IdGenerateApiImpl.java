package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.dubbo;

import cn.ruvik.spring.cloud.alibaba.dubbo.api.IdGenerateApi;
import cn.ruvik.spring.cloud.alibaba.dubbo.entity.Result;
import cn.ruvik.spring.cloud.alibaba.dubbo.gateway.service.SnowflakeService;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月14日 11:04:00
 */
@Service
public class IdGenerateApiImpl implements IdGenerateApi {

    @Autowired
    private SnowflakeService snowflakeService;

    @Override
    public Result getId(String s) {
        return snowflakeService.getId(s);
    }
}
