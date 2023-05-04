package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.Admin;
import com.atwangjin.yyb.pojo.AdminRole;
import com.atwangjin.yyb.result.R;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author WangJin
 * @create 2023-02-22 17:17
 */
public interface LoginService extends IService<Admin> {
    R login(String username, String password,String code ,HttpServletRequest request);

    Admin getAdminByUserName(String userName);


}
