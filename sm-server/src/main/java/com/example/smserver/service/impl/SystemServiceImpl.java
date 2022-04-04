package com.example.smserver.service.impl;

import com.example.smserver.core.CustomException;
import com.example.smserver.core.context.LoginContexts;
import com.example.smserver.entity.User;
import com.example.smserver.service.SystemService;
import com.example.smserver.utils.EncryptUtils;
import com.example.smserver.utils.RedisUtils;
import com.example.smserver.utils.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public User userLogin(String id, String password) throws CustomException {
        if (StringUtils.isEmpty(id)) {
            throw new CustomException(LoginContexts.USER_NOT_EXIST);
        }
        User user = userService.lambdaQuery()
                .eq(User::getNo, id).or()
                .eq(User::getPhone, id)
                .one();
        if (Objects.isNull(user)) {
            throw new CustomException(LoginContexts.USER_NOT_EXIST);
        }
        if (user.getPassword().equals(EncryptUtils.encrypt(password))) {
            return user;
        }
        throw new CustomException(LoginContexts.PASSWORD_IS_ERROR);
    }

    @Override
    public String createToken(HttpServletResponse response, String id) throws UnsupportedEncodingException {
        Long currentTimeMillis = System.currentTimeMillis();
        String token = TokenUtils.sign(id, currentTimeMillis);
        redisUtils.set(id, currentTimeMillis, TokenUtils.REFRESH_EXPIRE_TIME);
        response.setHeader("Authorization", token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        return token;
    }

    @Override
    public void authentication(String token) {
        if (StringUtils.isEmpty(token)){
            throw new CustomException(LoginContexts.TOKEN_INVALID);
        }
        String account = TokenUtils.getAccount(token);
        if (!redisUtils.hasKey(account)){
            throw new CustomException(LoginContexts.TOKEN_ERROR);
        }
    }

    @Override
    public Boolean logout(String token) {
        if (StringUtils.isEmpty(token)){
            throw new CustomException(LoginContexts.AUTHENTIC_FAIL);
        }
        String account = TokenUtils.getAccount(token);
        Long currentTime= TokenUtils.getCurrentTime(token);
        if (redisUtils.hasKey(account)) {
            Long currentTimeMillisRedis = (Long) redisUtils.get(account);
            if (currentTimeMillisRedis.equals(currentTime)) {
                redisUtils.del(account);
                return true;
            }
        }
        throw new CustomException(LoginContexts.TOKEN_ERROR);
    }
}
