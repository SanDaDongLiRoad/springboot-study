package com.lizhi.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 学生
 *
 * @author xulizhi-lenovo
 * @date 2019/5/29
 */
@Data
@Entity
public class Student {

    @Id
    private long id;

    String name;
}
