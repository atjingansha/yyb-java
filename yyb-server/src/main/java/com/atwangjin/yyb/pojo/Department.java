package com.atwangjin.yyb.pojo;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_department
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 路径
     */
    private String depPath;

    /**
     * 是否启用
     */
    private Integer enabled;

    /**
     * 是否上级
     */
    private Integer isParent;


    @ApiModelProperty(value="子部门列表")
    @TableField(exist=false)
    private List<Department> children;

    @ApiModelProperty(value="返回结果，存储过程使用")
    @TableField(exist=false)
    private Integer result;


    private static final long serialVersionUID = 1L;
}