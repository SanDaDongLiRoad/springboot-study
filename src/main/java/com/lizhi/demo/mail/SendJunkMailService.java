package com.lizhi.demo.mail;

import com.lizhi.demo.domain.AyUser;

import java.util.List;

/**
 * 发送用户邮件服务
 *
 * @author xulizhi-lenovo
 * @date 2019/5/28
 */
public interface SendJunkMailService {

    boolean sendJunkMail(List<AyUser> ayUserList);

}
