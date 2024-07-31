package com.uni.practice;


import lombok.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@Data
public class PracticeConfiguration {
    private String version;

    private String name;
}
