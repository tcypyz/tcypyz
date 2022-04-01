package com.example.smserver.core.base;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/1
 */
public class BaseController {

    final String X_FORWARDED_FOR = "x-forwarded-for";

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    /**
     * 获取请求token
     *
     * @return {@link String}
     */
    protected String getHeaderToken(){
        return getRequest().getHeader("token");
    }

    /**
     * 获取客户端Ip
     *
     * @return ip
     */
    protected String getClientIp(){
        HttpServletRequest request = getRequest();
        if (request.getHeader(X_FORWARDED_FOR) == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader(X_FORWARDED_FOR);
    }

    /**
     * 判断请求来源
     *
     * @return 结果
     */
    protected String getTerminal(){
        HttpServletRequest request = getRequest();
        String terminal = request.getHeader("User-Agent");
        String windows = "Windows NT";
        return terminal.contains(windows) ? "pc" : "mobile";
    }

}
