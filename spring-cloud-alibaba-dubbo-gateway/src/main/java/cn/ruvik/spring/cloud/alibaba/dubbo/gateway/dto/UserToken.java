package cn.ruvik.spring.cloud.alibaba.dubbo.gateway.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月26日 17:55:00
 */
@Data
public class UserToken implements Serializable {
    private static final long serialVersionUID = 5328962518890120980L;
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户登录账户
     */
    private String userNo;

    /**
     * 用户中文名
     */
    private String userName;

    private String token;

}
