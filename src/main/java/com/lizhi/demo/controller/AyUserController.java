package com.lizhi.demo.controller;

import com.lizhi.demo.domain.AyUser;
import com.lizhi.demo.service.AyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Demo class
 *
 * @author xulizhi-lenovo
 * @date 2019/5/23
 */
@Controller
@RequestMapping("ayUser")
public class AyUserController {

    @Autowired
    private AyUserService ayUserService;

    @RequestMapping("test")
    public String test(Model model) {
        //查询数据库所有用户
        List<AyUser> ayUser = ayUserService.findAll();
        model.addAttribute("users",ayUser);
        return "ayUser";
    }
}
