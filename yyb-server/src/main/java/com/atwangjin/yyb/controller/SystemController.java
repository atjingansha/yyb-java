package com.atwangjin.yyb.controller;

import com.atwangjin.yyb.pojo.*;
import com.atwangjin.yyb.result.R;
import com.atwangjin.yyb.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

/**
 * @author WangJin
 * @create 2023-02-23 17:25
 */
@RestController
@RequestMapping("system")
public class SystemController {


    @Autowired
   private MenuService menuService;

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private LoginService loginService;




    @ApiOperation("通过用户id查询菜单列表")
    @GetMapping("/config/menu")
    public List<Menu> getMenu(Principal principal){



        String userName = principal.getName();

        if (userName!=null){
            Admin admin= loginService.getAdminByUserName(userName);

            List<Menu> menu = menuService.getUserMenuById(admin.getId());


            return menu;
        }

        return null;


    }


    @ApiOperation("添加职位信息")
    @PostMapping("/basic/pos")
    public R addPos(@RequestBody Position position){


        Integer insert = positionService.addPos(position);

        if (insert==1) {
            return R.success("添加成功");

        }else {
            return R.error("添加失败");
        }
    }



    @ApiOperation("获取职位信息")
    @GetMapping("/basic/pos")
    public  List<Position> getPos(){


        List<Position> position= positionService.getPos();

        return position;
    }


    @ApiOperation("修改职位信息")
    @PutMapping("/basic/pos")
    public  R editPos(@RequestBody Position position){


        Integer posi= positionService.editPos(position);

        if (posi==1) {
            return R.success("修改成功");

        }else {
            return R.error("修改失败");
        }
    }

    @ApiOperation("删除职位信息")
    @DeleteMapping("/basic/pos/{id}")
    public  R deletePos(@PathVariable Integer  id){


        Integer posi= positionService.deletePos(id);

        if (posi==1) {
            return R.success("删除成功");

        }else {
            return R.error("删除失败");
        }
    }


    @ApiOperation("批量删除职位信息")
    @DeleteMapping("/basic/pos")
    public  R deleteManyPos(@RequestParam Integer[]  ids){


        boolean result= positionService.deleteManyPos(ids);


        if (result==true){
            return R.success("删除成功");

        }else {
            return R.error("删除失败");
        }

    }


}
