package com.uni.practice.enums;

import lombok.Getter;

/**
 * 性别
 *
 * @author zhuzw
 * @date 2024/11/16 09:58
 */
@Getter
public enum SexEnum {
    MAN(1, "男"),
    WOMAN(2, "女");
    private final Integer code;
    private final String desc;
    SexEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
