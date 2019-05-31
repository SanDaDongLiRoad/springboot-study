package com.lizhi.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Demo class
 *
 * @author xulizhi-lenovo
 * @date 2019/5/29
 */
@Data
@Entity
@Table(name = "student_course")
public class StudentCourse {

    @Id
    private long id;

    private long studentId;

    private long courseId;

    private int score;
}
