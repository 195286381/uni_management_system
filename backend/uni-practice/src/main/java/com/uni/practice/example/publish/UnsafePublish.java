package com.uni.practice.example.publish;

import com.uni.practice.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 不安全的发布对象.
 * @author zhuzw
 * @date 2024/11/18 14:42
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] states =  {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();

        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }
}

