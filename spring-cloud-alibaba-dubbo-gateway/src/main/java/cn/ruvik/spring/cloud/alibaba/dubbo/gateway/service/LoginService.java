package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.service;

import cn.ruvik.spring.cloud.alibaba.dubbo.entity.LoginUser;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月27日 09:45:00
 */
public interface LoginService {

    LoginUser login(String userName, String password);
}
