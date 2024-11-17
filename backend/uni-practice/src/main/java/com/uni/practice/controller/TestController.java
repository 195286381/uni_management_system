package com.uni.practice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhuzw
 * @date 2024/11/17 20:06
 */
@RestController
@RequestMapping("/practice/juc")
@Slf4j
public class TestController {
    private static AtomicInteger atomicInt = new AtomicInteger(1);
    @GetMapping("test")
    public String test() {
        log.info(atomicInt.getAndIncrement() + "");
        return "juc test";
    }
}
