package com.uni.practice.test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author zhuzw
 * @date 2024/11/19 12:24
 */
public class Test02 {
    public static void main(String[] args) throws FileNotFoundException {
        try(PrintWriter printWriter = new PrintWriter("/Users/zhuzhiwei/Desktop/printwrite_text.txt");) {
            printWriter.println("hello world");
            printWriter.println("hello world");
            printWriter.println("hello world");
            printWriter.println("hello world");
            printWriter.println("hello world");
            printWriter.println("hello world");
            printWriter.println("hello world");
            printWriter.println("hello world");
            printWriter.println("hello world");
            printWriter.println("输入用户信息");
        }

        //printWriter.flush();

    }
}
