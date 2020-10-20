package cn.ruvik.spring.cloud.alibaba.dubbo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2020/8/15 4:45 下午
 *
 * @author barry
 * Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 4536709687844487506L;
    String userName;
    String realName;
    String userToken;
    Date loginTime;
}
