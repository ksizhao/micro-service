package cn.ruvik.spring.cloud.alibaba.dubbo.api;

import cn.ruvik.spring.cloud.alibaba.dubbo.entity.LoginUser;
import cn.ruvik.spring.cloud.alibaba.dubbo.entity.PermissionDTO;

import java.util.List;

/**
 * @author zhaolc
 * @version 1.0
 * @description TODO
 * @createTime 2020年10月19日 10:16:00
 */
public interface LoginServiceApi {
   List<PermissionDTO>  findByUserName(String userName);

   LoginUser getUserName(String userName);
}
