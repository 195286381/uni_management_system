package com.uni.practice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 日志模型.
 * @author zhuzw
 * @date 2024/11/16 12:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PracticeLog {
    private Integer id;
    private String modelName;
    private String description;
}
