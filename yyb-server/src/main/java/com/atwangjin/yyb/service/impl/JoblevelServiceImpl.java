package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.mapper.JoblevelMapper;
import com.atwangjin.yyb.pojo.Joblevel;
import com.atwangjin.yyb.service.JoblevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author WangJin
 * @create 2023-03-01 9:53
 */
@Service
public class JoblevelServiceImpl extends ServiceImpl<JoblevelMapper,Joblevel> implements JoblevelService {

    @Autowired
    private JoblevelMapper joblevelMapper;

    @Override
    public List<Joblevel> getJob() {

        List<Joblevel> joblevels = joblevelMapper.selectList(null);

        return joblevels;
    }

    @Override
    public Boolean addJob(Joblevel joblevel) {
        joblevel.setCreateDate(new Date());
        joblevel.setEnabled(1);

        int insert = joblevelMapper.insert(joblevel);

        if (insert==1){
            return true;
        }
        return null;
    }

    @Override
    public Boolean deleteJob(Integer id) {
        int i = joblevelMapper.deleteById(id);

        if (i==1){
            return true;
        }
        return null;
    }

    @Override
    public Boolean updateJob(Joblevel joblevel) {
        if (joblevel.getEnable2()==false){
            joblevel.setEnabled(0);
        }else {
            joblevel.setEnabled(1);
        }

        int i = joblevelMapper.updateById(joblevel);

        if (i==1){
            return true;
        }
        return null;
    }

    @Override
    public boolean deleteManyJos(Integer[] ids) {
        List<Integer> collect = Arrays.stream(ids).collect(Collectors.toList());

        int i = joblevelMapper.deleteBatchIds(collect);

        if (i==ids.length){
            return true;
        }

        return false;
    }
}
