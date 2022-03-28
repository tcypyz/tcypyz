package com.example.smserver.config;

import com.example.smserver.core.CustomException;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultCode;
import com.example.smserver.core.result.ResultFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@ControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

    /**
     * 处理shiro异常
     *
     * @param shiroException          shiro异常
     * @param authorizationException 授权异常
     * @return 返回code 401
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({ShiroException.class, AuthorizationException.class})
    @ResponseBody
    public Result<String> handleShiroException(ShiroException shiroException, AuthorizationException authorizationException) {
        log.error("handleShiroException:{}",ResultCode.UNAUTHORIZED.data);
        return ResultFactory.buildResult(ResultCode.UNAUTHORIZED, ResultCode.UNAUTHORIZED);
    }

    /**
     * 自定义CustomException异常捕获
     * @param e
     * @return 返回400
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result<String> handleCustomException(CustomException e){
        log.error(e.getMessage());
        e.printStackTrace();
        return ResultFactory.buildFailResult(e.getMessage());
    }

    /**
     * 其他异常
     * @param e
     * @return 返回500
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> handleException(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        if (e instanceof NoHandlerFoundException){
            return ResultFactory.buildResult(ResultCode.NOT_FOUND,ResultCode.NOT_FOUND);
        }
        return ResultFactory.buildResult(ResultCode.INTERNAL_SERVER_ERROR,ResultCode.INTERNAL_SERVER_ERROR,e.getMessage());
    }
}
