package com.example.smserver.core.context;


/**
 * @description:
 * @author: zhh
 * @time: 2022/3/26
 */
public interface LoginContexts {


    String USER_STATE_ERROR = "用户状态异常，请重新登录";

    String AUTHENTIC_FAIL = "认证失败：身份验证异常";

    String USER_NOT_EXIST = "用户不存在";

    String PASSWORD_IS_ERROR = "密码错误";

    String LOGOUT_SUCCESS = "成功登出";

    String NO_LOGIN_USER = "用户未登录";

    String NAME_HAS_EXIST = "用户名已存在";

    String REGISTER_SUCCESS = "注册成功";

    String TOKEN_ERROR = "token已过期";

    String TOKEN_INVALID = "无效token";
}
