package com.uni.practice.service.impl;

import com.uni.practice.annotation.EnableLog;
import com.uni.practice.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zhuzw
 * @date 2024/11/16 10:04
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    @EnableLog(method = "addUser", predix = "添加用户")
    public boolean addUser() {
        System.out.println("添加用户成功");
        return true;
    }
}
