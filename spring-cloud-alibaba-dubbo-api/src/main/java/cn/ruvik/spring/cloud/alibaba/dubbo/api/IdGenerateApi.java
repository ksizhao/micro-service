package cn.ruvik.spring.cloud.alibaba.dubbo.api;


import cn.ruvik.spring.cloud.alibaba.dubbo.entity.Result;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年08月18日 16:40:00
 */
public interface IdGenerateApi {

    Result getId(String key);
}
