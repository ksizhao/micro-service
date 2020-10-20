package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.controller;

import cn.ruvik.spring.cloud.alibaba.dubbo.api.LoginServiceApi;
import cn.ruvik.spring.cloud.alibaba.dubbo.entity.LoginUser;
import cn.ruvik.spring.cloud.alibaba.dubbo.gateway.session.Session;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月19日 10:12:00
 */
@RestController
public class UserController {
    @Autowired
    private Session session;


    @Reference(check = false)
    private LoginServiceApi loginServiceApi;

    public LoginUser login(String userName, String password){
        LoginUser loginUser = LoginUser.builder()
                .userName(userName)
//                .realName(user.getRealName())
                .userToken(UUID.randomUUID().toString())
                .loginTime(new Date())
                .build();

        // 保存session
        session.saveSession(loginUser);
//
//        // 查询权限
//        List<PermissionDTO> permissions = permissionProvider.findByUserName(userName);
//        // 保存用户权限
//        session.saveUserPermissions(userName, permissions);
        return loginUser;
    }

    @GetMapping("/getUserInfo")
    @SentinelResource(value = "getUserInfo")
    public LoginUser getUserInfo(String userName){
        return loginServiceApi.getUserName(userName);
    }
}
