package com.atwangjin.yyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_role
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 角色名称
     */
    private String namezh;

    private static final long serialVersionUID = 1L;
}