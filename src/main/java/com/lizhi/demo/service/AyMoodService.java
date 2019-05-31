package com.lizhi.demo.service;

import com.lizhi.demo.domain.AyMood;

/**
 * 微信说说服务层
 *
 * @author xulizhi-lenovo
 * @date 2019/5/29
 */
public interface AyMoodService {

    /**
     * 保存
     * @param ayMood
     * @return
     */
    AyMood save(AyMood ayMood);

    /**
     * 异步保存
     * @param ayMood
     * @return
     */
    String asynSave(AyMood ayMood);
}
