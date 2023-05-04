package com.atwangjin.yyb.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangJin
 * @create 2023-02-22 16:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
    private long code;
    private String message;
    private Object obj;

    /**
     * @Author: Jim
     * @Description: 成功返回结果
     * @Params:
     */
    public static R success(String message){
        return new R(200,message,null );
    }


    public static R success(String message,Object obj){
        return new R(200,message,obj);
    }

    /**
     * @Author: Jim
     * @Description: 失败返回结果
     * @Params:
     */
    public static R error(String message){
        return new R(500,message,null);
    }

    public static R error(String message,Object obj){
        return new R(500,message,obj);
    }
}
