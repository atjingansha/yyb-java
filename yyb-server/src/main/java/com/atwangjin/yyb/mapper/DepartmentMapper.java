package com.atwangjin.yyb.mapper;

import com.atwangjin.yyb.pojo.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author WangJin
 * @create 2023-03-03 10:37
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    void addDept(Department department);

    void delDep(Department dep);
}
