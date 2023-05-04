package com.atwangjin.yyb.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WangJin
 * @create 2023-02-22 17:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminLogin {
    @ApiModelProperty(value="用户名",required = true)
    private String username;
    @ApiModelProperty(value="密码",required = true)
    private String password;
    @ApiModelProperty(value="验证码",required = true)
    private String code;
}
