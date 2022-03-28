package com.example.smserver.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Slf4j
public class TokenUtils {

    /**
     * token到期时间，毫秒为单位(60分钟*3)
     */
    public static final long EXPIRE_TIME= 60*60*1000*3;
    /**
     * RefreshToken到期时间，秒为单位(60分钟*3)
     */
    public static final long REFRESH_EXPIRE_TIME=60*60*3;
    /**
     * 密钥盐
     */
    private static final String TOKEN_SECRET="ljdyaasugasdbyu-ki2qnyun2xyzeuduxhsusnuzhebcyufguzxmixnnishijinhon3253nkjnj??";

    private static final String ISSUER = "fzdxzcxyjkzsbebssttypywz325";

    private static final String EQUALS = "============================================================================";

    /**
     * 生成token
     *
     * @param account     账户
     * @param currentTime 当前时间
     * @return {@link String}
     * @throws UnsupportedEncodingException 不支持编码异常
     */
    public static String sign(String account,Long currentTime) throws UnsupportedEncodingException {

        String token;
        try {
            Date expireAt=new Date(currentTime+EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer(ISSUER)
                    //存放数据
                    .withClaim("account",account)
                    .withClaim("currentTime",currentTime)
                    //过期时间
                    .withExpiresAt(expireAt)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException | JWTCreationException je) {
            throw je;
        }
        return token;
    }


    /**
     * token验证
     *
     * @param token 令牌
     * @return {@link Boolean}
     */
    public static Boolean verify(String token) {
        //创建token验证器
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer(ISSUER).build();
        DecodedJWT jwt=jwtVerifier.verify(token);
        System.out.println(EQUALS);
        System.out.println("认证通过：");
        System.out.println("account:" + jwt.getClaim("account").asString());
        System.out.println("过期时间:" + jwt.getExpiresAt().toLocaleString());
        System.out.println(EQUALS);
        return true;
    }


    /**
     * 获得账户
     *
     * @param token 令牌
     * @return {@link String}
     */
    public static String getAccount(String token){
        try{
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("account").asString();
        }catch (JWTDecodeException e){
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 获取当前时间
     *
     * @param token 令牌
     * @return {@link Long}
     */
    public static Long getCurrentTime(String token){
        try{
            DecodedJWT jwt =JWT.decode(token);
            return jwt.getClaim("currentTime").asLong();

        }catch (JWTCreationException e){
            return null;
        }
    }
}
