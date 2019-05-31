package com.lizhi.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 微信说说实体
 *
 * @author xulizhi-lenovo
 * @date 2019/5/29
 */
@Data
@Entity
@Table(name = "ay_mood")
public class AyMood implements Serializable{
    private static final long serialVersionUID = 9001714970516016019L;

    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 说说内容
     */
    private String content;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 点赞数量
     */
    private Integer praiseNum;
    /**
     * 发表时间
     */
    private Date publishTime;

}
