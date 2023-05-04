package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.mapper.MenuRoleMapper;
import com.atwangjin.yyb.pojo.MenuRole;
import com.atwangjin.yyb.service.MenuRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author WangJin
 * @create 2023-02-24 10:14
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements MenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    @Override
    public List<MenuRole> getMenuRoleByRids(List<Integer> ridList) {

        QueryWrapper<MenuRole> wrapper=new QueryWrapper<>();

        wrapper.in("rid",ridList);


        List<MenuRole> menuRole = menuRoleMapper.selectList(wrapper);


        return menuRole;
    }

    @Override
    public Boolean updateRole(Integer id, Integer[] mids) {

        QueryWrapper<MenuRole> wrapper=new QueryWrapper();

        wrapper.eq("rid",id);

        menuRoleMapper.delete(wrapper);

        if (mids==null ||mids.length==0){
            return true;
        }

        int a=0;
        for (Integer mid : mids) {
            MenuRole menuRole=new MenuRole();

            menuRole.setRid(id);
            menuRole.setMid(mid);
            int insert = menuRoleMapper.insert(menuRole);
            a +=insert;
        }


        if (a==mids.length){
            return true;
        }

        return null;
    }

    @Override
    public List<Integer> getMenuByRid(Integer id) {


        QueryWrapper<MenuRole> wrapper=new QueryWrapper<>();

        wrapper.eq("rid",id);
        List<MenuRole> menuRoleList = menuRoleMapper.selectList(wrapper);

        List<Integer> mids=new ArrayList<>();
        for (MenuRole menuRole : menuRoleList) {
            Integer mid = menuRole.getMid();
            mids.add(mid);
        }

        List<Integer> collect = mids.stream().distinct().collect(Collectors.toList());

        return collect;
    }
}
