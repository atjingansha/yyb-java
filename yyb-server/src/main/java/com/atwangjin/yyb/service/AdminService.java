package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-06 14:24
 */
public interface AdminService extends IService<Admin> {
    List<Admin> getAll(String keyWord);

    Boolean deleteRole(Integer id);

    Boolean updateEnable(Admin admin);

}
