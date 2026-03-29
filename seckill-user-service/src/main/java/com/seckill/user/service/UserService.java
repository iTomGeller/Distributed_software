package com.seckill.user.service;

import com.seckill.user.entity.User;
import com.seckill.user.vo.LoginResponse;

public interface UserService {
    void register(String username, String password, String email, String phone);
    LoginResponse login(String username, String password);
    User getUserById(Long userId);
    User getUserByUsername(String username);
}