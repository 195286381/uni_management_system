package com.uni;


import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JasyptStartTest {

    @Autowired
    private StringEncryptor stringEncryptor;


    @Test
    public void test() {
        String encrypt = stringEncryptor.encrypt("XiaoZhu1990");
        System.out.println("encrypt = " + encrypt);
    }
}

