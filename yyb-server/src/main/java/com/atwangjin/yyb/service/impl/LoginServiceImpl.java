package com.atwangjin.yyb.service.impl;

import com.atwangjin.yyb.config.security.JwtUtils;
import com.atwangjin.yyb.mapper.AdminMapper;
import com.atwangjin.yyb.pojo.Admin;
import com.atwangjin.yyb.pojo.AdminRole;
import com.atwangjin.yyb.result.R;
import com.atwangjin.yyb.service.LoginService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author WangJin
 * @create 2023-02-22 17:17
 */
@Service
public class LoginServiceImpl extends ServiceImpl<AdminMapper, Admin> implements LoginService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AdminMapper adminMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param request
     * @return
     */
    @Override
    public R login(String username, String password,String code ,HttpServletRequest request) {


        String captcha = (String) request.getSession().getAttribute("captcha");

        if (code==null || !captcha.equalsIgnoreCase(code)){
            return R.error("验证码有误");
        }


        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if (userDetails !=null && passwordEncoder.matches(password,userDetails.getPassword())){
            String token = jwtUtils.generateToken(userDetails);


            //更新security登录用户对象
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                    new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            Map tokenMap=new HashMap();
            tokenMap.put("token",token);
            tokenMap.put("tokenHead",tokenHead);

            return R.success("登录成功",tokenMap);
        }
        return R.error("登录失败");
    }


    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    @Override
    public Admin getAdminByUserName(String userName) {

        QueryWrapper<Admin> wrapper=new QueryWrapper<>();
        wrapper.eq("username",userName).eq("enabled",1);

        Admin admin = adminMapper.selectOne(wrapper);

        return admin;
    }


}
