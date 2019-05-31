package com.lizhi.demo.mq;

import com.lizhi.demo.domain.AyMood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * 生产者
 *
 * @author xulizhi-lenovo
 * @date 2019/5/29
 */
@Service
public class AyMoodProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(String destinationName, final String message) {
        jmsMessagingTemplate.convertAndSend(destinationName,message);
    }

    public void sendMessage(String destinationName, final AyMood ayMood) {
        jmsMessagingTemplate.convertAndSend(destinationName, ayMood);
    }
}
