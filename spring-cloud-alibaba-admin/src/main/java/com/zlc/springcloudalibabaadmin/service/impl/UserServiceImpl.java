package com.zlc.springcloudalibabaadmin.service.impl;

import cn.ruvik.spring.cloud.alibaba.dubbo.api.IdGenerateApi;
import cn.ruvik.spring.cloud.alibaba.dubbo.entity.LoginUser;
import com.zlc.springcloudalibabaadmin.dao.entity.UserDO;
import com.zlc.springcloudalibabaadmin.dao.mapper.UserMapper;
import com.zlc.springcloudalibabaadmin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月20日 11:22:00
 */
@Component
@Slf4j
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Reference(check = false)
    private IdGenerateApi idGenerateApi;

    private static int count=1;

    @Override
    public UserDO getUserName(String userName) {
        return userMapper.getByName(userName);
    }

    @Override
    public void insertUserInfo() {
        long start=System.currentTimeMillis();
        List<UserDO> userDOList=new LinkedList<>();
//        for (int i = 1001; i < 100; i++) {
//
////            userMapper.insert(userDO);
//        }
        UserDO userDO=new UserDO();
        userDO.setAge(count);
        userDO.setCreateTime(new Date());
        userDO.setId(idGenerateApi.getId("").getId());
        userDO.setPassword("12345"+count);
        userDO.setUserName("zlc"+count);
        userDO.setRealName("test"+count);
        userDOList.add(userDO);
        userMapper.batchInsertFromDual(userDOList);
        count++;
        log.info("计数值[{}]",count);
        long end=System.currentTimeMillis();
        log.info("耗时[{}]毫秒",end-start);
    }
}
