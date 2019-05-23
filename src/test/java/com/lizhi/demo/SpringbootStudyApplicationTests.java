package com.lizhi.demo;

import com.lizhi.demo.domain.AyUser;
import com.lizhi.demo.service.AyUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootStudyApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AyUserService ayUserService;

    @Test
    public void contextLoads() {

    }

    /**
     * Mysql集成Spring Boot简单测试
     */
    @Test
    public void mySqlTest(){
        String sql = "select id,name,password from ay_user";
        List<AyUser> userList =
                (List<AyUser>) jdbcTemplate.query(sql, new RowMapper<AyUser>(){
                    @Override
                    public AyUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                        AyUser user = new AyUser();
                        user.setId(rs.getString("id"));
                        user.setName(rs.getString("name"));
                        user.setPassword(rs.getString("password"));
                        return user;
                    }
                });
        System.out.println("查询成功：");
        for(AyUser user:userList){
            System.out.println("【id】: " + user.getId() + "；【name】: " + user.getName());
        }
    }

    @Test
    public void testRepository(){
        //查询所有数据
        List<AyUser> userList =  ayUserService.findAll();
        System.out.println("findAll() :" + userList.size());
        //通过name查询数据
        List<AyUser> userList2 = ayUserService.findByName("阿毅");
        System.out.println("findByName() :" + userList2.size());
        Assert.isTrue(userList2.get(0).getName().equals("阿毅"),"data error!");
        //通过name模糊查询数据
        List<AyUser> userList3 = ayUserService.findByNameLike("%毅%");
        System.out.println("findByNameLike() :" + userList3.size());
        Assert.isTrue(userList3.get(0).getName().equals("阿毅"),"data error!");
        //通过id列表查询数据
        List<String> ids = new ArrayList<String>();
        ids.add("1");
        ids.add("2");
        List<AyUser> userList4 = ayUserService.findByIdIn(ids);
        System.out.println("findByIdIn() :" + userList4.size());
        //分页查询数据
        PageRequest pageRequest = new PageRequest(0,10);
        Page<AyUser> userList5 =  ayUserService.findAll(pageRequest);
        System.out.println("page findAll():" + userList5.getTotalPages() + "/" + userList5.getSize());
        //新增数据
        AyUser ayUser = new AyUser();
        ayUser.setId("3");
        ayUser.setName("test");
        ayUser.setPassword("123");
        ayUserService.save(ayUser);
        //删除数据
        ayUserService.delete("3");
    }

    @Test
    public void testTransaction(){
        AyUser ayUser = new AyUser();
        ayUser.setId("3");
        ayUser.setName("阿华");
        ayUser.setPassword("123");
        ayUserService.save(ayUser);
    }
}
