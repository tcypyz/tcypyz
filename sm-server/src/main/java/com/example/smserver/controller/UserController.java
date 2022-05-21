package com.example.smserver.controller;

import com.example.smserver.api.service.AccountService;
import com.example.smserver.core.CustomException;
import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.base.BaseDTO;
import com.example.smserver.core.context.LoginContexts;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultCode;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.dto.IdDTO;
import com.example.smserver.dto.PasswordDTO;
import com.example.smserver.dto.UserAddDTO;
import com.example.smserver.dto.UserEditDTO;
import com.example.smserver.entity.User;
import com.example.smserver.service.UserService;
import com.example.smserver.utils.TokenUtils;
import com.example.smserver.vo.DashboardVO;
import com.example.smserver.vo.MenuVO;
import com.example.smserver.vo.UserInfoVO;
import com.example.smserver.vo.UserTableVO;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @GetMapping("/menu")
    public Result<List<MenuVO>> menu() {
        try {
            String token = getHeaderToken();
            String account = TokenUtils.getAccount(token);
            if (StringUtils.isEmpty(account)) {
                throw new CustomException();
            }
            Long id = Long.parseLong(account);
            return ResultFactory.buildSuccessResult(accountService.getMenuList(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildResult(ResultCode.UNAUTHORIZED, LoginContexts.TOKEN_ERROR, null);
        }
    }

    @PostMapping(value = "/add")
    public Result<String> addUser(@RequestBody UserAddDTO dto) {
        accountService.addUser(dto);
        return ResultFactory.buildSuccessResult();
    }

    @PostMapping(value = "/list")
    public Result<PageInfo<UserTableVO>> list(@RequestBody BaseDTO dto) {
        PageInfo<UserTableVO> pageInfo = accountService.getPage(dto);
        return ResultFactory.buildSuccessResult(pageInfo);
    }

    @PostMapping(value = "/delete")
    public Result<String> deleteUser(@RequestBody IdDTO dto) {
        accountService.deleteUser(dto);
        return ResultFactory.buildSuccessResult();
    }

    @PostMapping(value = "/edit")
    public Result<String> editUser(@RequestBody UserEditDTO dto) {
        accountService.editUser(dto);
        return ResultFactory.buildSuccessResult();
    }

    @GetMapping(value = "/dashboard/info")
    public Result<DashboardVO> getDashboardInfo(){
        User user = userService.getById(getUserId());
        DashboardVO info = accountService.getDashboardInfo(user);
        return ResultFactory.buildSuccessResult(info);
    }

    @GetMapping(value = "/info")
    public Result<UserInfoVO> getUserInfo(){
        User user = userService.getById(getUserId());
        UserInfoVO info = accountService.getUserInfo(user.getId(), user.getRoleId());
        return ResultFactory.buildSuccessResult(info);
    }

    @PostMapping(value = "/change/password")
    public Result<String> change(@RequestBody PasswordDTO dto){
        accountService.changePassword(getUserId(), dto.getPass());
        return ResultFactory.buildSuccessResult();
    }
}
