package com.atwangjin.yyb.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_admin_role
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRole implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer adminid;

    /**
     * 权限id
     */
    private Integer rid;

    private static final long serialVersionUID = 1L;
}