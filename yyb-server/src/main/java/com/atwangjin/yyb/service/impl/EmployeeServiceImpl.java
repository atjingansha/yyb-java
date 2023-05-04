package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.mapper.EmployeeMapper;
import com.atwangjin.yyb.pojo.Employee;
import com.atwangjin.yyb.pojo.PageResult;
import com.atwangjin.yyb.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-08 14:46
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public PageResult getAllEmp(Employee employee, LocalDate[] localDates, Integer pageNum, Integer pageSize) {

        Page<Employee> page=new Page<>(pageNum,pageSize);


      IPage iPage= employeeMapper.getAllEmp(page,employee,localDates);


      PageResult pageResult=new PageResult(iPage.getTotal(),iPage.getRecords());

        return pageResult;
    }

    @Override
    public String getMaxWorkId() {
        QueryWrapper<Employee> wrapper =new QueryWrapper<>();

        wrapper.select("workId").orderByDesc("workId");

        List<Employee> employeeList = employeeMapper.selectList(wrapper);


        String workID = employeeList.get(0).getWorkID();


        String format = String.format("%08d", Integer.parseInt(workID) + 1);
        return format;
    }
}
