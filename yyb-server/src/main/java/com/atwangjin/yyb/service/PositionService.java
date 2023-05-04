package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.Position;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-02-28 9:56
 */
public interface PositionService extends IService<Position> {
    Integer addPos(Position position);

    List<Position> getPos();

    Integer editPos(Position position);

    Integer deletePos(Integer id);

    boolean deleteManyPos(Integer[] ids);
}
