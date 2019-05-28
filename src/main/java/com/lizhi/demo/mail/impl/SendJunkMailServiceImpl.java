package com.lizhi.demo.mail.impl;

import com.lizhi.demo.domain.AyUser;
import com.lizhi.demo.mail.SendJunkMailService;
import com.lizhi.demo.service.AyUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * 发送用户邮件服务
 *
 * @author xulizhi-lenovo
 * @date 2019/5/28
 */
@Slf4j
@Service
public class SendJunkMailServiceImpl implements SendJunkMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AyUserService ayUserService;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public boolean sendJunkMail(List<AyUser> ayUserList) {
        try{
            if(ayUserList == null || ayUserList.size() <= 0 ) {
                return Boolean.FALSE;
            }
            for(AyUser ayUser: ayUserList){
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                //邮件发送方
                message.setFrom(from);
                //邮件主题
                message.setSubject("地瓜今日特卖");
                //邮件接收方
                message.setTo("1013310985@qq.com");
                //邮件内容
                message.setText(ayUser.getName() +" ,你知道么？厦门地瓜今日特卖，一斤只要9元");
                //发送邮件
                mailSender.send(mimeMessage);
            }
        }catch(Exception ex){
            log.error("sendJunkMail error and ayUser=%s", ayUserList, ex);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
