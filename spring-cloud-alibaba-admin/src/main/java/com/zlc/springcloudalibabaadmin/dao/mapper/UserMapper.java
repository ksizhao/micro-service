package com.zlc.springcloudalibabaadmin.dao.mapper;


import com.zlc.springcloudalibabaadmin.dao.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserMapper {

    UserDO getByName(String name);

    UserDO getById(Long id);

    Long insert(UserDO userDO);
}
