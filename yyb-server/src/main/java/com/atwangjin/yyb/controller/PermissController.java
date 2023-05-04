package com.atwangjin.yyb.controller;

import com.atwangjin.yyb.pojo.Admin;
import com.atwangjin.yyb.pojo.Menu;
import com.atwangjin.yyb.pojo.MenuRole;
import com.atwangjin.yyb.pojo.Role;
import com.atwangjin.yyb.result.R;
import com.atwangjin.yyb.service.LoginService;
import com.atwangjin.yyb.service.MenuRoleService;
import com.atwangjin.yyb.service.MenuService;
import com.atwangjin.yyb.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-01 16:05
 */
@RestController
@RequestMapping("system/basic")
public class PermissController {


    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private MenuRoleService menuRoleService;


    @ApiOperation("获取所有角色")
    @GetMapping("permiss")
    public List<Role> getRole(){
        List<Role> roles=  roleService.getRole();

        return roles;
    }

    @ApiOperation("获取所有菜单")
    @GetMapping("permiss/menus")
    public List<Menu> getMenus(Principal principal){

        String userName = principal.getName();

        if (userName!=null){
            Admin admin= loginService.getAdminByUserName(userName);

            List<Menu> menu = menuService.getUserAllMenuById(admin.getId());


            return menu;
        }

      return null;
    }


    @ApiOperation("根据角色id查询菜单id")
    @GetMapping("permiss/mid/{rid}")
    public List<Integer> getMenuByRid(@PathVariable Integer rid){

        List<Integer> menuId = menuRoleService.getMenuByRid(rid);

        return menuId;
    }

    @ApiOperation("更新角色")
    @PutMapping("permiss")
    public R updateRole(@RequestParam Integer rid ,@RequestParam Integer[] mids){
      Boolean result=  menuRoleService.updateRole(rid,mids);


      if (result==true){

          return R.success("更新成功");
      }
      return null;
    }
}
