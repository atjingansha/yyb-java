package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-02-23 17:29
 */
public interface MenuService extends IService<Menu> {


    List<Menu> getUserMenuById(Integer id);

    List<Menu> getUserAllMenuById(Integer id);

    List<Integer> getMenuByRid(Integer id);
}
