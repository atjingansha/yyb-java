package com.atwangjin.yyb.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_employee_train
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTrain implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 员工编号
     */
    private Integer eid;

    /**
     * 培训日期
     */
    private Date traindate;

    /**
     * 培训内容
     */
    private String traincontent;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}