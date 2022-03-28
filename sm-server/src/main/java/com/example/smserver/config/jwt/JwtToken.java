package com.example.smserver.config.jwt;

import org.apache.shiro.authc.AuthenticationToken;

import java.io.Serializable;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
public class JwtToken implements AuthenticationToken, Serializable {
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
