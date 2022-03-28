package com.example.smserver.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
public class EncryptUtils {
    private static final String DEFAULT_ALGORITHM_NAME = "MD5";
    private static final Object DEFAULT_SALT = "asdefulselta";
    private static final int DEFAULT_HASH_ITERATIONS = 1;

    /**
     * 加密
     *
     * @param password 密码
     * @return {@link String}
     */
    public static String encrypt(String password) {
        return new SimpleHash(DEFAULT_ALGORITHM_NAME, password, DEFAULT_SALT, DEFAULT_HASH_ITERATIONS).toString();
    }
}
