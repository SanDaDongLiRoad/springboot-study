package com.lizhi.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 课程
 *
 * @author xulizhi-lenovo
 * @date 2019/5/29
 */
@Data
@Entity
public class Course {

    @Id
    private long id;

    String name;
}
