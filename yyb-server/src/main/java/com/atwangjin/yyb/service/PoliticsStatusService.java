package com.atwangjin.yyb.service;

import com.atwangjin.yyb.pojo.PoliticsStatus;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-10 10:42
 */
public interface PoliticsStatusService extends IService<PoliticsStatus> {
    List<PoliticsStatus> getPoliticsStatus();


}
