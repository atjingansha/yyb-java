package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.mapper.MenuMapper;
import com.atwangjin.yyb.pojo.AdminRole;
import com.atwangjin.yyb.pojo.Menu;
import com.atwangjin.yyb.pojo.MenuRole;
import com.atwangjin.yyb.service.AdminRoleService;
import com.atwangjin.yyb.service.MenuRoleService;
import com.atwangjin.yyb.service.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.xdevapi.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author WangJin
 * @create 2023-02-23 17:30
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    @Autowired
    private MenuMapper menuMapper;


    @Autowired
    private MenuRoleService menuRoleService;

    @Autowired
    private AdminRoleService adminRoleService;


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Menu> getUserMenuById(Integer id) {


        ValueOperations operations = redisTemplate.opsForValue();

        List<Menu> list = (List) operations.get("menu_" + id);


        if (CollectionUtils.isEmpty(list)) {


            List<AdminRole> adminRoleList = adminRoleService.getAdminRoleByAdminId(id);


            List<Integer> ridList = new ArrayList<>();
            adminRoleList.stream().forEach(adminRole -> {
                ridList.add(adminRole.getRid());
            });

            List<MenuRole> menuRole = menuRoleService.getMenuRoleByRids(ridList);


            List<Integer> menuIdList = new ArrayList<>();
            menuRole.stream().forEach(menuRole1 -> {
                menuIdList.add(menuRole1.getMid());
            });

            List<Integer> collect = menuIdList.stream().distinct().collect(Collectors.toList());

            QueryWrapper<Menu> wrapper = new QueryWrapper<>();

            wrapper.in("id", collect);

            List<Menu> menuList = menuMapper.selectList(wrapper);


            List<Menu> menus = menuMapper.selectList(null);


            //找到所有的1级菜单
            List<Menu> mList = new ArrayList<>();


            for (int i = 0; i < menus.size(); i++) {

                if (menus.get(i).getParentid() != null) {
                    if (menus.get(i).getParentid() == 1) {
                        mList.add(menus.get(i));
                    }
                }
            }


            //为一级菜单设置子菜单准备递归
            for (Menu menu : mList) {
                //获取父菜单下所有子菜单调用getChildList
                List<Menu> childList = getChildList(String.valueOf(menu.getId()), menuList);
                menu.setChildren(childList);
            }


            List<Menu> mList2 = new ArrayList<>();

            for (Menu menu : mList) {
                for (Menu me : menuList) {
                    if (me.getParentid() == menu.getId()) {
                        mList2.add(menu);
                    }
                }
            }

            List<Menu> collect1 = mList2.stream().distinct().collect(Collectors.toList());


            operations.set("menu_"+id,collect1,60, TimeUnit.MINUTES);
            return collect1;


        }else {
            return list;
        }
    }

    @Override
    public List<Menu> getUserAllMenuById(Integer id) {

        List<AdminRole> adminRoleList= adminRoleService.getAdminRoleByAdminId(id);


        List<Integer> ridList=new ArrayList<>();
        adminRoleList.stream().forEach(adminRole -> {
            ridList.add(adminRole.getRid());
        });

        List<MenuRole> menuRole = menuRoleService.getMenuRoleByRids(ridList);


        List<Integer> menuIdList=new ArrayList<>();
        menuRole.stream().forEach(menuRole1 -> {
            menuIdList.add(menuRole1.getMid());
        });

        List<Integer> collect = menuIdList.stream().distinct().collect(Collectors.toList());

        QueryWrapper<Menu> wrapper=new QueryWrapper<>();

        wrapper.in("id",collect);

        List<Menu> menuList = menuMapper.selectList(wrapper);


        List<Menu> menus = menuMapper.selectList(null);




        //找到所有的1级菜单
        List<Menu> mList = new ArrayList<>();


        for (int i = 0; i < menus.size(); i++) {

            if (menus.get(i).getParentid()!=null) {
                if (menus.get(i).getParentid() == 1) {
                    mList.add(menus.get(i));
                }
            }
        }



        //为一级菜单设置子菜单准备递归
        for (Menu menu:mList) {
            //获取父菜单下所有子菜单调用getChildList
            List<Menu> childList = getChildList(String.valueOf(menu.getId()),menuList);
            menu.setChildren(childList);
        }


        List<Menu> mList2 = new ArrayList<>();

        for ( Menu menu : mList) {
            for (Menu me : menuList) {
                if (me.getParentid()==menu.getId()){
                    mList2.add(menu);
                }
            }
        }

        List<Menu> collect1 = mList2.stream().distinct().collect(Collectors.toList());

        List<Menu> menus1=new ArrayList<>();

        Menu menu=new Menu();

        menu.setId(1);
        menu.setName("所有");
        menu.setChildren(collect1);
        menus1.add(menu);

        return menus1;
    }

    @Override
    public List<Integer> getMenuByRid(Integer id) {
        List<AdminRole> adminRoleList= adminRoleService.getAdminRoleByAdminId(id);


        List<Integer> ridList=new ArrayList<>();
        adminRoleList.stream().forEach(adminRole -> {
            ridList.add(adminRole.getRid());
        });

        List<MenuRole> menuRole = menuRoleService.getMenuRoleByRids(ridList);


        List<Integer> menuIdList=new ArrayList<>();
        menuRole.stream().forEach(menuRole1 -> {
            menuIdList.add(menuRole1.getMid());
        });

        List<Integer> collect = menuIdList.stream().distinct().sorted().collect(Collectors.toList());

        return collect;
    }


    public List<Menu> getChildList(String id,List<Menu> menuList){
        //构建子菜单
        List<Menu> childList = new ArrayList<>();
        //遍历传入的list
        for (Menu menu:menuList) {
            //所有菜单的父id与传入的根节点id比较，若相等则为该级菜单的子菜单
            if (String.valueOf(menu.getParentid()).equals(id)){
                childList.add(menu);
            }
        }
        //递归
        for (Menu m:childList) {
            m.setChildren(getChildList(String.valueOf(m.getId()),menuList));
        }
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }



}
