package com.example.smserver.api.service;

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
     * @param password 密码
     * @param id       id
     * @return {@link User}
     * @throws CustomException 自定义异常
     */
    User userLogin(String id, String password) throws CustomException;

    /**
     * 创建令牌
     *
     * @param response 响应
     * @param id       id
     * @return {@link String}
     */
    String createToken( HttpServletResponse response, String id) throws UnsupportedEncodingException;

    /**
     * 身份验证
     *
     * @param token 令牌
     */
    void authentication(String token);

    /**
     * 注销
     *
     * @param token 令牌
     * @return {@link Boolean}
     */
    Boolean logout(String token);
}
