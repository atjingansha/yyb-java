package com.atwangjin.yyb.mapper;

import com.atwangjin.yyb.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-02-22 17:21
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
    List<Admin> getAll(@Param("id") Integer id,@Param("keyWord") String keyWord);
}
