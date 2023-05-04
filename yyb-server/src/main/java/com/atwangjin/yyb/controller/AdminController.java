package com.atwangjin.yyb.controller;

import com.atwangjin.yyb.pojo.Admin;
import com.atwangjin.yyb.result.R;
import com.atwangjin.yyb.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-06 14:03
 */
@RestController
@RequestMapping("system/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    @ApiOperation("获取所有操作员")
    public List<Admin> getAll(@RequestParam("keyword") String keyword){

      List<Admin> adminList=  adminService.getAll(keyword);

      return adminList;
    }



    @DeleteMapping("{id}")
    @ApiOperation("删除操作员")
    public R deleteRole(@PathVariable Integer id){
       Boolean result= adminService.deleteRole(id);

       if (result==true){
           return R.success("删除成功");
       }

       return null;
    }






    @PutMapping
    @ApiOperation("修改状态")
    public R updateEnable(@RequestBody Admin admin){
        Boolean result= adminService.updateEnable(admin);

        if (result==true){
            return R.success("修改成功");
        }

        return null;
    }
}
