package com.lizhi.demo.service.impl;

import com.lizhi.demo.domain.AyUser;
import com.lizhi.demo.repository.AyUserRepository;
import com.lizhi.demo.service.AyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@Transactional
@Service
public class AyUserServiceImpl implements AyUserService {

    @Autowired
    private AyUserRepository ayUserRepository;

    @Override
    public AyUser findById(String id) {
        return ayUserRepository.findById(id).get();
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
}
