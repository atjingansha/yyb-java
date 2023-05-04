package com.atwangjin.yyb.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
/**
 * @author WangJin
 * @create 2023-03-08 15:34
 */
public class DateFormat implements Converter<String, LocalDate>{

    @Override
    public LocalDate convert(String s) {
        try {
            return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyy-MM-dd"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
