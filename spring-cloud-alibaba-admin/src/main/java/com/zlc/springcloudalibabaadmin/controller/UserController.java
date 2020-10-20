package com.zlc.springcloudalibabaadmin.controller;

import com.zlc.springcloudalibabaadmin.event.EmailEvent;
import com.zlc.springcloudalibabaadmin.event.MsgPublish;
import com.zlc.springcloudalibabaadmin.event.MsgPublishEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月17日 10:08:00
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private ApplicationContext applicationContext;


    @Autowired
    MsgPublish msgPublish;
    @GetMapping("/getUserName")
    public String getUserName(String userName){
        if("msg".equals(userName)){
            applicationContext.publishEvent(new MsgPublishEvent(userName));
            return "触发消息事件";
        }else if("email".equals(userName)){
            applicationContext.publishEvent(new EmailEvent(userName));
            return "触发邮件事件";
        }
        return "admin";
    }

}
