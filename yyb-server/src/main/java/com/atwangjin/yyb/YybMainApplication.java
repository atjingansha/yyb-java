package com.atwangjin.yyb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan(basePackages = "com.atwangjin.yyb.mapper")
public class YybMainApplication
{
    public static void main( String[] args ){
        SpringApplication.run(YybMainApplication.class,args);
    }
}
