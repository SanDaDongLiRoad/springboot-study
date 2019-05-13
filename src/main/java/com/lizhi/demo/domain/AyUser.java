package com.lizhi.demo.domain;

import lombok.Data;

/**
 * @author 10133
 */
@Data
public class AyUser {

    /**
     * 主键
     */
    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

}
