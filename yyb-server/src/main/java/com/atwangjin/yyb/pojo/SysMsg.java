package com.atwangjin.yyb.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_sys_msg
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMsg implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 消息id
     */
    private Integer mid;

    /**
     * 0表示群发消息
     */
    private Integer type;

    /**
     * 这条消息是给谁的
     */
    private Integer adminid;

    /**
     * 0 未读 1 已读
     */
    private Integer state;

    private static final long serialVersionUID = 1L;
}