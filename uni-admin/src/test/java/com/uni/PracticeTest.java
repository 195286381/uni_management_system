package com.uni;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class )
@Profile("aliyun")
public class PracticeTest {
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void redisTest() {
        Set<String> keys = redisTemplate.keys("sys_config:*");
        System.out.println(keys);
        for (String key : keys) {
            redisTemplate.delete(key);
        }
    }
}
