package com.atwangjin.yyb.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_joblevel
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Joblevel implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    /**
     * 职称等级
     */
    private Object titlelevel;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /**
     * 是否启用
     */
    private Integer enabled;

    @TableField(exist=false)
    private Boolean enable2;


    private static final long serialVersionUID = 1L;
}