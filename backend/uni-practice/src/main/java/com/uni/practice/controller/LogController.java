package com.uni.practice.controller;

import com.uni.practice.domain.PracticeLog;
import com.uni.practice.service.LogService;
import com.uni.practice.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhuzw
 * @date 2024/11/16 09:52
 */
@RestController
@RequestMapping("/practice/log")
public class LogController {

    @Resource
    private LogService logService;

    @Resource
    private UserService userService;

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/aop")
    public String aop() {
        return userService.addUser() ? "success" : "fail";
    }

    @RequestMapping("/add")
    public String add(){
        PracticeLog log = new PracticeLog(null, "practice", "test");
        logService.addLog(log);
        return "添加成功";
    }
}
