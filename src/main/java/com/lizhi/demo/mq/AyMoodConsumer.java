package com.lizhi.demo.mq;

import com.lizhi.demo.domain.AyMood;
import com.lizhi.demo.service.AyMoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 消费者
 *
 * @author xulizhi-lenovo
 * @date 2019/5/29
 */
@Component
public class AyMoodConsumer {

    @Autowired
    private AyMoodService ayMoodService;

    @JmsListener(destination = "ay.queue")
    public void receiveQueue(String text) {
        System.out.println("用户发表说说【" + text + "】成功");
    }

    @JmsListener(destination = "ay.queue.asyn.save")
    public void receiveQueue(AyMood ayMood){
        ayMoodService.save(ayMood);
    }
}
