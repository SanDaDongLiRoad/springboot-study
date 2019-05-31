package com.lizhi.demo.service;

import com.lizhi.demo.domain.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

/**
 * 用户服务层接口
 *
 * @author xulizhi-lenovo
 * @date 2019/5/23
 */
public interface AyUserService {

    /**
     * 根据ID查询单个
     * @param id
     * @return
     */
    AyUser findById(String id);

    /**
     * 查询所有
     * @return
     */
    List<AyUser> findAll();

    /**
     * 保存
     * @param ayUser
     * @return
     */
    AyUser save(AyUser ayUser);

    /**
     * 根据ID删除单个
     * @param id
     */
    void delete(String id);

    /**
     * 分页查询
     * @param pageable
     * @return
     */
    Page<AyUser> findAll(Pageable pageable);

    /**
     * 通过名字相等查询
     * @param name
     * @return
     */
    List<AyUser> findByName(String name);

    /**
     * 通过名字like查询
     * @param name
     * @return
     */
    List<AyUser> findByNameLike(String name);

    /**
     * 通过主键id集合查询
     * @param ids
     * @return
     */
    List<AyUser> findByIdIn(Collection<String> ids);

    /**
     * 根据名字和密码查询用户
     * @param name
     * @param password
     * @return
     */
    AyUser findByNameAndPassword(String name, String password);

    /**
     * 异步查询
     * @return
     */
    Future<List<AyUser>> findAsynAll();
}
