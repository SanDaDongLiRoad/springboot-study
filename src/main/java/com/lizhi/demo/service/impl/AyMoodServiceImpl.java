package com.lizhi.demo.service.impl;

import com.lizhi.demo.domain.AyMood;
import com.lizhi.demo.mq.AyMoodProducer;
import com.lizhi.demo.repository.AyMoodRepository;
import com.lizhi.demo.service.AyMoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 微信说说服务层
 *
 * @author xulizhi-lenovo
 * @date 2019/5/29
 */
@Service
public class AyMoodServiceImpl implements AyMoodService {

    //队列
//    private static Destination destination = new ActiveMQQueue("ay.queue.asyn.save");

    @Autowired
    private AyMoodProducer ayMoodProducer;

    @Autowired
    private AyMoodRepository ayMoodRepository;

    @Override
    public AyMood save(AyMood ayMood) {
        return ayMoodRepository.save(ayMood);
    }

    @Override
    public String asynSave(AyMood ayMood) {
        //往队列ay.queue.asyn.save推送消息，消息内容为说说实体
        ayMoodProducer.sendMessage("ay.queue.asyn.save", ayMood);
        return "success";
    }
}
