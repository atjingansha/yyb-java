package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.mapper.PositionMapper;
import com.atwangjin.yyb.pojo.Position;
import com.atwangjin.yyb.service.PositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author WangJin
 * @create 2023-02-28 9:57
 */
@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper,Position> implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public Integer addPos(Position position) {
        position.setCreateDate(new Date());
        position.setEnabled(1);


        int insert = positionMapper.insert(position);

        if (insert==1){
            return insert;
        }else {
            return null;
        }

    }

    @Override
    public List<Position> getPos() {
        List<Position> positions = positionMapper.selectList(null);



        return positions;
    }

    @Override
    public Integer editPos(Position position) {

        int update = positionMapper.updateById(position);

        if (update==1){
            return update;
        }else {
            return null;
        }

    }

    @Override
    public Integer deletePos(Integer id) {

        int i = positionMapper.deleteById(id);
        return i;
    }



    @Override
    public boolean deleteManyPos(Integer[] ids) {

        List<Integer> collect = Arrays.stream(ids).collect(Collectors.toList());

        int i = positionMapper.deleteBatchIds(collect);

        if (i==ids.length){
            return true;
        }
        return false;
    }
}
