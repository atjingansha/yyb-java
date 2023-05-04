package com.atwangjin.yyb.pojo;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_menu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * url
     */
    private String url;

    /**
     * path
     */
    private String path;

    /**
     * 组件
     */
    private String component;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 图标
     */
    private String iconcls;

    /**
     * 是否保持激活
     */
    private Integer keepalive;

    /**
     * 是否要求权限
     */
    private Integer requireauth;

    /**
     * 父id
     */
    private Integer parentid;

    /**
     * 是否启用
     */
    private Integer enabled;



    @ApiModelProperty(value="子菜单")
    @TableField(exist=false)
    private List<Menu> children;

    @ApiModelProperty(value = "角色列表")
    @TableField(exist = false)
    private List<Role> roles;

    private static final long serialVersionUID = 1L;
}