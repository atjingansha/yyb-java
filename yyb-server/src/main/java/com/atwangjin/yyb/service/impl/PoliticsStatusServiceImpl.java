package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.mapper.PoliticsStatusMapper;
import com.atwangjin.yyb.pojo.PoliticsStatus;
import com.atwangjin.yyb.service.PoliticsStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-10 10:42
 */
@Service
public class PoliticsStatusServiceImpl extends ServiceImpl<PoliticsStatusMapper,PoliticsStatus> implements PoliticsStatusService  {

    @Autowired
    private PoliticsStatusMapper politicsStatusMapper;


    @Override
    public List<PoliticsStatus> getPoliticsStatus() {


        List<PoliticsStatus> politicsStatuses = politicsStatusMapper.selectList(null);

        return politicsStatuses;
    }
}
