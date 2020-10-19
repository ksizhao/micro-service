package com.zlc.springcloudalibabaadmin.controller;

import lombok.extern.slf4j.Slf4j;
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



    @GetMapping("/getUserName")
    public String getUserName(){
        return "admin";
    }
}
