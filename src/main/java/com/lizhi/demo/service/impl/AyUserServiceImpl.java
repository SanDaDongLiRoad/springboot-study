package com.lizhi.demo.service.impl;

import com.lizhi.demo.dao.AyUserDao;
import com.lizhi.demo.domain.AyUser;
import com.lizhi.demo.repository.AyUserRepository;
import com.lizhi.demo.service.AyUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * 用户服务层实现类
 *
 * @author xulizhi-lenovo
 * @date 2019/5/23
 */
@Slf4j
@Transactional
@Service
public class AyUserServiceImpl implements AyUserService {

    private static final String ALL_USER = "ALL_USER_LIST";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private AyUserRepository ayUserRepository;

    @Autowired
    private AyUserDao ayUserDao;

    @Override
    public AyUser findById(String id) {

        //step.1  查询Redis缓存中的所有数据
        List<AyUser> ayUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
        if(ayUserList != null && ayUserList.size() > 0){
            for(AyUser user : ayUserList){
                if (user.getId().equals(id)){
                    return user;
                }
            }
        }
        //step.2  查询数据库中的数据
        AyUser ayUser = ayUserRepository.findById(id).get();
        if(ayUser != null){
            //step.3 将数据插入到Redis缓存中
            redisTemplate.opsForList().leftPush(ALL_USER, ayUser);
        }
        return ayUser;
    }

    @Override
    public List<AyUser> findAll() {
        return ayUserRepository.findAll();
    }

    @Transactional
    @Override
    public AyUser save(AyUser ayUser) {
        AyUser saveUser = ayUserRepository.save(ayUser);
        //出现空指针异常
        String error = null;
        error.split("/");
        return saveUser;
    }

    @Override
    public void delete(String id) {
        ayUserRepository.deleteById(id);
        log.info("userId:" + id + "用户被删除");
    }

    @Override
    public Page<AyUser> findAll(Pageable pageable) {
        return ayUserRepository.findAll(pageable);
    }

    @Override
    public List<AyUser> findByName(String name) {
        return ayUserRepository.findByName(name);
    }

    @Override
    public List<AyUser> findByNameLike(String name) {
        return ayUserRepository.findByNameLike(name);
    }

    @Override
    public List<AyUser> findByIdIn(Collection<String> ids) {
        return ayUserRepository.findByIdIn(ids);
    }

    @Override
    public AyUser findByNameAndPassword(String name, String password) {
        return ayUserDao.findByNameAndPassword(name, password);
    }
}
