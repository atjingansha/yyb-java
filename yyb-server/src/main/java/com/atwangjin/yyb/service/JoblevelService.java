package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.Joblevel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-01 9:52
 */
public interface JoblevelService extends IService<Joblevel> {
    List<Joblevel> getJob();

    Boolean addJob(Joblevel joblevel);

    Boolean deleteJob(Integer id);

    Boolean updateJob(Joblevel joblevel);

    boolean deleteManyJos(Integer[] ids);
}
