package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.mapper.RoleMapper;
import com.atwangjin.yyb.pojo.Role;
import com.atwangjin.yyb.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-01 16:19
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> getRole() {

        List<Role> roles = roleMapper.selectList(null);

        return roles;
    }
}
