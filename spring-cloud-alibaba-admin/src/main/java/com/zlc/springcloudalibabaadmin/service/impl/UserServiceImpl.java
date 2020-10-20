package com.zlc.springcloudalibabaadmin.service.impl;

import cn.ruvik.spring.cloud.alibaba.dubbo.entity.LoginUser;
import com.zlc.springcloudalibabaadmin.dao.entity.UserDO;
import com.zlc.springcloudalibabaadmin.dao.mapper.UserMapper;
import com.zlc.springcloudalibabaadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月20日 11:22:00
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDO getUserName(String userName) {
        return userMapper.getByName(userName);
    }
}
