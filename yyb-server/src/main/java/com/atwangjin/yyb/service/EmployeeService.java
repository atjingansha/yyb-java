package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.Employee;
import com.atwangjin.yyb.pojo.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-08 14:46
 */

public interface EmployeeService extends IService<Employee> {
    PageResult getAllEmp(Employee employee, LocalDate[] localDates, Integer pageNum, Integer pageSize);

    String getMaxWorkId();


}
