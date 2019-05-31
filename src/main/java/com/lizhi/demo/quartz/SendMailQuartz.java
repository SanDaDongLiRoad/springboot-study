//package com.lizhi.demo.quartz;
//
//import com.lizhi.demo.domain.AyUser;
//import com.lizhi.demo.mail.SendJunkMailService;
//import com.lizhi.demo.service.AyUserService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * 定时器类
// *
// * @author xulizhi-lenovo
// * @date 2019/5/28
// */
//@Slf4j
//@Component
//@Configurable
//@EnableScheduling
//public class SendMailQuartz {
//
//    @Autowired
//    private SendJunkMailService sendJunkMailService;
//
//    @Autowired
//    private AyUserService ayUserService;
//
//    /**
//     * 每5秒执行一次
//     */
//    @Scheduled(cron = "*/5 * *  * * * ")
//    public void reportCurrentByCron(){
//
//        List<AyUser> userList = ayUserService.findAll();
//
//        if (userList == null || userList.size() <= 0) {
//            return;
//        }
//        //发送邮件
////        sendJunkMailService.sendJunkMail(userList);
//        log.info("定时器运行了!!!");
//    }
//}
