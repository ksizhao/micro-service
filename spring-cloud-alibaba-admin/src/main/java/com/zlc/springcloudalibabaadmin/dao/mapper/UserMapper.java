package com.zlc.springcloudalibabaadmin.dao.mapper;


import com.zlc.springcloudalibabaadmin.dao.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
public interface UserMapper {

    UserDO getByName(String name);

    UserDO getById(Long id);

    Long insert(UserDO userDO);

    /**
     * 批量插入数据
     *
     * @param list 批量数据
     * @return 插入条数
     */
    int batchInsertFromDual(@Param("list") List<UserDO> list);



}
