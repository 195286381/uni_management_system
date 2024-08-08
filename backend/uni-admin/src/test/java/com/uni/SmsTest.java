package com.uni;


import com.uni.sms.service.SmsService;
import org.apache.ibatis.type.JdbcType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class )
public class SmsTest {
    @Autowired
    SmsService smsService;
    @Test
    public void testSms() {
        smsService.sendSms("13760372349", "123456");
    }

    @Test
    public void test113() {
        //JdbcType.BIGINT;
    }
}
