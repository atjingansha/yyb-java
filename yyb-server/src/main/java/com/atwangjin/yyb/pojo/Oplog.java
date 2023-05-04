package com.atwangjin.yyb.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_oplog
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oplog implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 添加日期
     */
    private Date adddate;

    /**
     * 操作内容
     */
    private String operate;

    /**
     * 操作员ID
     */
    private Integer adminid;

    private static final long serialVersionUID = 1L;
}