package com.zlc.springcloudalibabaadmin.dao.entity;

import lombok.Data;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Data
public class UserDO {
    private Long id;

    private String userName;

    private String password;

    private String realName;

    private String userToken;

    private Integer age;
}
