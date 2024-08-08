package com.uni.practice.io;

import java.io.*;

/**
 * iotest
 *
 * @author zhuzwx
 * @date 2024/8/7 10:41
 */
public class InputStremTest {
    public static void main(String[] args) {
        write();
    }

    public static final void read() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("/Users/zhuzhiwei/szjt-ios/szjt-gitlab/szjt_app_ios/HBuilder-uniPluginDemo/HBuilder-Hello/Pandora/apps/__UNI__E9C0715/www/__uniappview.html");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException ex) {

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try(InputStream inputStream1 = new FileInputStream("/Users/zhuzhiwei/szjt-ios/szjt-gitlab/szjt_app_ios/HBuilder-uniPluginDemo/HBuilder-Hello/Pandora/apps/__UNI__E9C0715/www/__uniappview.html")) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream1));
            bufferedReader.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void write() {
        // 使用try with resource 读取文件.
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/zhuzhiwei/Desktop/版本规范.txt"))) {
            bufferedWriter.write("hello world");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
