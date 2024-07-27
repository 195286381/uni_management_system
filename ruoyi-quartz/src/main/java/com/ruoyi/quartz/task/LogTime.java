package com.ruoyi.quartz.task;

import org.springframework.stereotype.Component;

@Component("logTime")
public class LogTime {
    public void log() {
        System.out.println("当前时间:" + System.currentTimeMillis());
    }
}
