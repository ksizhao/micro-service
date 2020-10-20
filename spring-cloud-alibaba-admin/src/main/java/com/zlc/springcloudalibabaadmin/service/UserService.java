package com.zlc.springcloudalibabaadmin.service;

import cn.ruvik.spring.cloud.alibaba.dubbo.entity.LoginUser;
import com.zlc.springcloudalibabaadmin.dao.entity.UserDO;


/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月20日 11:22:00
 */
public interface UserService {
     UserDO getUserName(String userName);
}
