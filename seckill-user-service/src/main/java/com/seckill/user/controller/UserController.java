package com.seckill.user.controller;

import com.seckill.common.result.Result;
import com.seckill.common.util.JwtUtil;
import com.seckill.user.dto.LoginRequest;
import com.seckill.user.dto.RegisterRequest;
import com.seckill.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "用户服务")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result<?> register(@RequestBody RegisterRequest request) {
        userService.register(request.getUsername(), request.getPassword(), request.getEmail(), request.getPhone());
        return Result.success("注册成功");
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginRequest request) {
        return Result.success(userService.login(request.getUsername(), request.getPassword()));
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    public Result<?> getUserInfo(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return Result.fail(401, "请先登录");
        }
        String token = authorization.substring(7);
        Long userId = JwtUtil.getUserIdFromToken(token);
        return Result.success(userService.getUserById(userId));
    }

    @ApiOperation("用户登出")
    @PostMapping("/logout")
    public Result<?> logout() {
        // 由于使用 JWT，登出操作可以在客户端完成，服务端不需要特殊处理
        return Result.success("登出成功");
    }
}