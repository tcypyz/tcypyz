package com.example.smserver.controller;

import com.example.smserver.core.base.BaseController;
import com.example.smserver.core.context.LoginContexts;
import com.example.smserver.core.result.Result;
import com.example.smserver.core.result.ResultCode;
import com.example.smserver.core.result.ResultFactory;
import com.example.smserver.dto.LoginDTO;
import com.example.smserver.entity.User;
import com.example.smserver.api.service.SystemService;
import com.example.smserver.vo.LoginVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: zhh
 * @time: 2022/3/14
 */
@RestController
@RequestMapping("/sys")
public class SystemController extends BaseController {

    @Autowired
    private SystemService systemService;

    @RequestMapping("/filter/error")
    @ApiOperation("异常接口")
    @ApiIgnore
    public Result<String> handleError(){
        return ResultFactory.buildResult(ResultCode.UNAUTHORIZED, LoginContexts.TOKEN_ERROR);
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    public Result<LoginVO> login(@RequestBody LoginDTO dto, HttpServletResponse response) throws Exception {
        User user = systemService.userLogin(dto.getId(), dto.getPassword());
        String token = systemService.createToken(response, user.getId().toString());
        LoginVO result = LoginVO.builder().id(user.getId())
                .username(user.getName())
                .phone(user.getPhone())
                .token(token).build();

        return ResultFactory.buildSuccessResult(result);
    }

    @GetMapping("/authentication")
    @ApiOperation("验证登录")
    public Result<String> authentication(){
        try{
            systemService.authentication(getHeaderToken());
            return ResultFactory.buildSuccessResult();
        }catch (Exception e){
            return ResultFactory.buildResult(ResultCode.UNAUTHORIZED,e.getMessage());
        }
    }

    @GetMapping("/logout")
    @ApiOperation("登出")
    public Result<String> logout(){
        try {
            systemService.logout(getHeaderToken());
            return ResultFactory.buildSuccessResult();
        } catch (Exception e) {
            return ResultFactory.buildResult(ResultCode.UNAUTHORIZED, e.getMessage());
        }
    }

}
