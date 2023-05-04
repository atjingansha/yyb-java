package com.atwangjin.yyb.mapper;

import com.atwangjin.yyb.pojo.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;

/**
 * @author WangJin
 * @create 2023-03-08 14:47
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    IPage getAllEmp(Page<Employee> page,
                    @Param("employee") Employee employee,@Param("beginDateScope") LocalDate[] beginDateScope);


}
