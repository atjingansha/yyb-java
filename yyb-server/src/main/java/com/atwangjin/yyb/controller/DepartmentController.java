package com.atwangjin.yyb.controller;

import com.atwangjin.yyb.pojo.Department;
import com.atwangjin.yyb.result.R;
import com.atwangjin.yyb.service.DepartmentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-03 10:33
 */
@RestController
@RequestMapping("system/basic/department")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;


    @ApiOperation("获取所有部门")
    @GetMapping
    public List<Department> getAllDepartment() {
        List<Department> department = departmentService.getAllDepartment();

        return department;
    }


    @ApiOperation("添加部门")
    @PostMapping
    public R addDept(@RequestBody Department department){
       Boolean result= departmentService.addDept(department);

       if (result==true){
           return R.success("添加成功");
       }

       return null;
    }

    @ApiOperation(value="删除部门")
    @DeleteMapping("/{id}")
    public R delDep(@PathVariable Integer id){
        return departmentService.delDep(id);
    }


}
