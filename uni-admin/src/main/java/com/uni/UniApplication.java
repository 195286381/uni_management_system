package com.uni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author uni
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class UniApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(UniApplication.class, args);
        System.out.println(" Uni 后台服务启动成功 ");
    }
}
