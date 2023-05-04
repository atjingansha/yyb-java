package com.atwangjin.yyb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author WangJin
 * @create 2023-03-08 15:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {
    /**
     * 总条数
     */
    private Long total;

    /**
     * 数据 list
     */
    private List<?> data;
}
