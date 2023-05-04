package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.mapper.AdminMapper;
import com.atwangjin.yyb.pojo.Admin;
import com.atwangjin.yyb.service.AdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-06 14:25
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public List<Admin> getAll( String keyword) {

        Admin admin= (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Integer id = admin.getId();


        List<Admin> adminList = adminMapper.getAll(id, keyword);




        return adminList;
    }

    @Override
    public Boolean deleteRole(Integer id) {

        int i = adminMapper.deleteById(id);

        if (i==1
        ){
            return true;
        }
        return null;
    }

    @Override
    public Boolean updateEnable(Admin admin) {


        if (admin.getEnabled()==1){
            admin.setEnabled2(true);


        }else {
            admin.setEnabled2(false);
        }


        int i = adminMapper.updateById(admin);
        if (i==1
        ){
            return true;
        }
        return null;

    }
}
