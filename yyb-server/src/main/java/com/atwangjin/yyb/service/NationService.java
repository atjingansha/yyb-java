package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.Nation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-10 10:47
 */
public interface NationService extends IService<Nation> {
    List<Nation> getNation();

}
