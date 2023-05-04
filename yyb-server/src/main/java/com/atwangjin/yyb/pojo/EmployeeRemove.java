package com.atwangjin.yyb.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName t_employee_remove
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRemove implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 员工id
     */
    private Integer eid;

    /**
     * 调动后部门
     */
    private Integer afterdepid;

    /**
     * 调动后职位
     */
    private Integer afterjobid;

    /**
     * 调动日期
     */
    private Date removedate;

    /**
     * 调动原因
     */
    private String reason;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}