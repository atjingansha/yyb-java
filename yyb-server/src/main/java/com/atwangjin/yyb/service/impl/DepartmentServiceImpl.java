package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.mapper.DepartmentMapper;
import com.atwangjin.yyb.pojo.Department;
import com.atwangjin.yyb.result.R;
import com.atwangjin.yyb.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-03 10:36
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper,Department>
        implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;



    @Override
    public  List<Department> getAllDepartment() {

        List<Department> departments = departmentMapper.selectList(null);

        List<Department> rootNode = new ArrayList<>();
        for (Department Department : departments) {
            if (Department.getParentId()==-1){
                rootNode.add(Department);
            }
        }


        for (Department department : rootNode) {
            List<Department> childList = getChildList(department.getId(), departments);
            department.setChildren(childList);
        }


        return rootNode;
    }

    @Override
    public Boolean addDept(Department department) {

        department.setEnabled(1);

        departmentMapper.addDept(department);


        if (department.getResult()==1){
            return true;
        }

        return null;
    }


    @Override
    public R delDep(Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentMapper.delDep(dep);
        if(-2 == dep.getResult()){
            return R.error("该部门下还有子部门，删除失败！");
        }

        if(-1 == dep.getResult()){
            return R.error("该部门下还有员工，删除失败！");
        }

        if(1 == dep.getResult()){
            return R.success("删除成功");
        }
        return R.error("删除失败");

    }


    public List<Department> getChildList(Integer id,List<Department> menuList){
        //构建子菜单
        List<Department> childList = new ArrayList<>();
        //遍历传入的list
        for (Department menu:menuList) {
            //所有菜单的父id与传入的根节点id比较，若相等则为该级菜单的子菜单
            if (menu.getParentId()==id){
                childList.add(menu);
            }
        }
        //递归
        for (Department m:childList) {
            m.setChildren(getChildList(m.getId(),menuList));
        }
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }



}
