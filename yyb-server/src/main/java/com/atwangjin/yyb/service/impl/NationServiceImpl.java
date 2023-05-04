package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.mapper.NationMapper;
import com.atwangjin.yyb.pojo.Nation;
import com.atwangjin.yyb.service.NationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-10 10:47
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper,Nation> implements NationService {


    @Autowired
    private NationMapper nationMapper;

    @Override
    public List<Nation> getNation() {

        List<Nation> nationList = nationMapper.selectList(null);

        return nationList;
    }
}
