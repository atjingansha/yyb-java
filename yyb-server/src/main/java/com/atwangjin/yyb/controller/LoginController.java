package com.atwangjin.yyb.controller;

import com.atwangjin.yyb.pojo.Admin;
import com.atwangjin.yyb.pojo.AdminLogin;
import com.atwangjin.yyb.result.R;
import com.atwangjin.yyb.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author WangJin
 * @create 2023-02-22 17:11
 */
@RestController
public class LoginController {


    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    @ApiOperation("登录之后返回token")
    public R login(@RequestBody AdminLogin adminLogin, HttpServletRequest request){
        return loginService.login(adminLogin.getUsername(),adminLogin.getPassword(),adminLogin.getCode(),request);
    }


    @GetMapping("/logout")
    @ApiOperation("退出登录")
    public R logout(){
        return R.success("退出成功");
    }

    @GetMapping("/admin/info")
    @ApiOperation("获取当前登录用户信息")
    public Admin getUserInfo(Principal principal){
        if (principal==null){
            return null;
        }

        String userName = principal.getName();
       Admin admin= loginService.getAdminByUserName(userName);
       admin.setPassword(null);
       return admin;
    }

}
