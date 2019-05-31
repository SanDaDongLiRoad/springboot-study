package com.lizhi.demo.repository;

import com.lizhi.demo.domain.AyMood;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 说说repository
 *
 * @author xulizhi-lenovo
 * @date 2019/5/29
 */
public interface AyMoodRepository extends JpaRepository<AyMood,String> {
}
