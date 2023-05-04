package com.atwangjin.yyb.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_mail_log
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailLog implements Serializable {
    /**
     * 消息id
     */
    private String msgid;

    /**
     * 接收员工id
     */
    private Integer eid;

    /**
     * 状态（0:消息投递中 1:投递成功 2:投递失败）
     */
    private Integer status;

    /**
     * 路由键
     */
    private String routekey;

    /**
     * 交换机
     */
    private String exchange;

    /**
     * 重试次数
     */
    private Integer count;

    /**
     * 重试时间
     */
    private Date trytime;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}