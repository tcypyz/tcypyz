package com.example.smserver.config.shiro;

import com.example.smserver.config.jwt.JwtToken;
import com.example.smserver.core.context.LoginContexts;
import com.example.smserver.entity.User;
import com.example.smserver.service.RoleService;
import com.example.smserver.service.impl.UserServiceImpl;
import com.example.smserver.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/28
 */
@Component
@Slf4j
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleService roleService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long userId = Long.getLong(TokenUtils.getAccount(principals.toString()));
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();
        User user = userService.getById(userId);
        return null;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String account = TokenUtils.getAccount(token);
        if (Objects.isNull(account)){
            throw  new AuthenticationException(LoginContexts.AUTHENTIC_FAIL);
        }
        Long useId = Long.parseLong(account);
        User user = userService.getById(useId);
        if (Objects.isNull(user)) {
            throw new AuthenticationException(LoginContexts.USER_NOT_EXIST);
        }
        return new SimpleAuthenticationInfo(token, token, "MyRealm");
    }
}
