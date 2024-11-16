package com.uni.practice.service.impl;

import com.uni.practice.annotation.EnableLog;
import com.uni.practice.domain.PracticeLog;
import com.uni.practice.mapper.PracticeLogMapper;
import com.uni.practice.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 添加用户信息到数据库.
 * @author zhuzw
 * @date 2024/11/16 12:07
 */
@Service
public class LogServiceImpl implements LogService {
    @Resource
    private PracticeLogMapper practiceLogMapper;

    @EnableLog(method = "method", predix = "添加日志")
    @Override
    public void addLog(PracticeLog log) {
        practiceLogMapper.insert(log);
    }
}
