package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.mapper.AdminRoleMapper;
import com.atwangjin.yyb.pojo.AdminRole;
import com.atwangjin.yyb.service.AdminRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-02-23 17:51
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public List<AdminRole> getAdminRoleByAdminId(Integer id) {

        QueryWrapper<AdminRole> wrapper=new QueryWrapper<>();

        wrapper.eq("adminId",id);

        List<AdminRole> adminRole = adminRoleMapper.selectList(wrapper);

        return adminRole;
    }
}
