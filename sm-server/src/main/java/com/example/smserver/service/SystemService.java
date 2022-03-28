package com.example.smserver.service;

import com.example.smserver.core.CustomException;
import com.example.smserver.entity.User;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
public interface SystemService {

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param no       没有
     * @param phone    电话
     * @param password 密码
     * @return {@link String}
     * @throws CustomException 自定义异常
     */
    User userLogin(String username, String no, String phone, String password) throws CustomException;

    /**
     * 创建令牌
     *
     * @param response 响应
     * @param id       id
     * @return {@link String}
     */
    String createToken( HttpServletResponse response, String id) throws UnsupportedEncodingException;

}
