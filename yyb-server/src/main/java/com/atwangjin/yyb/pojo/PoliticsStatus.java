package com.atwangjin.yyb.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_politics_status
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliticsStatus implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 政治面貌
     */
    private String name;

    private static final long serialVersionUID = 1L;
}