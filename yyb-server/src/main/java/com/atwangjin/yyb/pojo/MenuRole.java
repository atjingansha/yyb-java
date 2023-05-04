package com.atwangjin.yyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_menu_role
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuRole implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单id
     */
    private Integer mid;

    /**
     * 权限id
     */
    private Integer rid;

    private static final long serialVersionUID = 1L;
}