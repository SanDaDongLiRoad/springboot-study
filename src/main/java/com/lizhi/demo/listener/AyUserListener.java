package com.lizhi.demo.listener;

import com.lizhi.demo.domain.AyUser;
import com.lizhi.demo.service.AyUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Date;
import java.util.List;

/**
 * 监听器
 *
 * @author xulizhi-lenovo
 * @date 2019/5/27
 */
@Slf4j
@WebListener
public class AyUserListener implements ServletContextListener {

    private static final String ALL_USER = "ALL_USER_LIST";

    @Autowired
    private AyUserService ayUserService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        //查询数据库所有的用户
        List<AyUser> ayUserList =  ayUserService.findAll();
        //清除缓存中的用户数据
        redisTemplate.delete(ALL_USER);
        //将数据存放到redis缓存中
        redisTemplate.opsForList().leftPushAll(ALL_USER, ayUserList);
        //真实项目中需要注释掉，查询所有的用户数据
        List<AyUser> queryUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
//        System.out.println("缓存中目前的用户数有：" + queryUserList.size() + " 人");
//        System.out.println(new Date()+"ServletContext上下文初始化");
        log.info("ServletContext上下文初始化");
        log.info("缓存中目前的用户数有：" + queryUserList.size() + " 人");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
//        System.out.println(new Date()+"ServletContext上下文销毁");
        log.info("ServletContext上下文销毁");
    }
}
