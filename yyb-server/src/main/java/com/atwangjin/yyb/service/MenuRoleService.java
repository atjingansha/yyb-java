package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-02-24 10:14
 */
public interface MenuRoleService extends IService<MenuRole> {
    List<MenuRole> getMenuRoleByRids(List<Integer> ridList);

    Boolean updateRole(Integer id, Integer[] mids);

    List<Integer> getMenuByRid(Integer id);
}
