package com.atwangjin.yyb.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_appraise
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appraise implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 员工id
     */
    private Integer eid;

    /**
     * 考评日期
     */
    private Date appdate;

    /**
     * 考评结果
     */
    private String appresult;

    /**
     * 考评内容
     */
    private String appcontent;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}