package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.AdminRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-02-23 17:50
 */
public interface AdminRoleService extends IService<AdminRole> {


    List<AdminRole> getAdminRoleByAdminId(Integer id);
}
