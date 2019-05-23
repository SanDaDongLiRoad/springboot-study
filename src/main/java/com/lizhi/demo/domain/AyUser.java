package com.lizhi.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 10133
 */
@Data
@Entity
@Table(name = "ay_user")
public class AyUser {

    /**
     * 主键
     */
    @Id
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
