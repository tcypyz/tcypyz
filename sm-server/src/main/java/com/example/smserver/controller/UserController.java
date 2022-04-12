package com.example.smserver.controller;

import com.example.smserver.core.CustomException;
import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.context.LoginContexts;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultCode;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.service.UserService;
import com.example.smserver.service.impl.UserServiceImpl;
import com.example.smserver.utils.TokenUtils;
import com.example.smserver.vo.MenuVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/4
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/menu")
    public Result<List<MenuVO>> menu(){
        try {
            String token = getHeaderToken();
            String account = TokenUtils.getAccount(token);
            if(StringUtils.isEmpty(account)){
                throw new CustomException();
            }
            Long id = Long.parseLong(account);
            return ResultFactory.buildSuccessResult(userService.getMenuList(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildResult(ResultCode.UNAUTHORIZED, LoginContexts.TOKEN_ERROR,null);
        }
    }

    @PostMapping(value = "/add")
    public Result<String> addUser(){
        return ResultFactory.buildSuccessResult();
    }
}
