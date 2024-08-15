package com.uni;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 启动程序
 * 
 * @author zhuzw
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Slf4j
public class UniApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(UniApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner()
    {
        return args -> log.info(" Uni后台服务启动成功.");
    }
}
