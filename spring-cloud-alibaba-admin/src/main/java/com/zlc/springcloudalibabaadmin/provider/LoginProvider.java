package com.zlc.springcloudalibabaadmin.provider;

import cn.ruvik.spring.cloud.alibaba.dubbo.api.LoginServiceApi;
import cn.ruvik.spring.cloud.alibaba.dubbo.entity.LoginUser;
import cn.ruvik.spring.cloud.alibaba.dubbo.entity.PermissionDTO;
import com.zlc.springcloudalibabaadmin.dao.entity.UserDO;
import com.zlc.springcloudalibabaadmin.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月19日 17:50:00
 */
@Service
public class LoginProvider implements LoginServiceApi {


    @Autowired
    private UserService userService;

    @Override
    public List<PermissionDTO> findByUserName(String userName) {
        return null;
    }

    @Override
    public LoginUser getUserName(String userName) {
        UserDO userDO = userService.getUserName(userName);
        LoginUser loginUser = LoginUser.builder()
                .userName(userName)
                .realName(userDO.getRealName())
                .userToken(userDO.getUserToken())
                .loginTime(new Date())
                .build();
        return loginUser;
    }
}
