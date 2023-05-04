package com.atwangjin.yyb.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_nation
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nation implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 民族
     */
    private String name;

    private static final long serialVersionUID = 1L;
}