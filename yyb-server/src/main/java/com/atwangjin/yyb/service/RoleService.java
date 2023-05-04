package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-01 16:08
 */
public interface RoleService extends IService<Role> {
    List<Role> getRole();

}
