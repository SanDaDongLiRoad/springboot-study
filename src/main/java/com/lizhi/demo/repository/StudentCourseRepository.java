package com.lizhi.demo.repository;

import com.lizhi.demo.domain.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Demo class
 *
 * @author xulizhi-lenovo
 * @date 2019/5/29
 */
public interface StudentCourseRepository extends JpaRepository<StudentCourse,Long> {
}
