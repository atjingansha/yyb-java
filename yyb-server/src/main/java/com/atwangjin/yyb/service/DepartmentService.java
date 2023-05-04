package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.Department;
import com.atwangjin.yyb.result.R;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-03 10:35
 */
public interface DepartmentService extends IService<Department> {
    List<Department> getAllDepartment();


    Boolean addDept(Department department);

    R delDep(Integer id);
}
