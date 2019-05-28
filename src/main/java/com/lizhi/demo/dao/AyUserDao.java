package com.lizhi.demo.dao;

import com.lizhi.demo.domain.AyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户DAO
 *
 * @author xulizhi-lenovo
 * @date 2019/5/28
 */
@Mapper
public interface AyUserDao {

    /**
     * 通过用户名和密码查询用户
     * @param name
     * @param password
     * @return
     */
    AyUser findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
