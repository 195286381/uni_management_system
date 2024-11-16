package com.uni.practice.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhuzw
 * @date 2024/11/16 19:06
 */
public class Demo01 {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = "{\"a\": 123,\"b\": 234}";
        try {
            ObjectNode o = objectMapper.readValue(jsonStr, ObjectNode.class);
            JsonNode a = o.get("a");
            System.out.println("a = " + a);
            JsonNode b = o.get("b");
            System.out.println("b = " + b);
            System.out.println(o);
            // 获取json的a

            // read用户将字符串转换为java对象.
            A a1 = objectMapper.readValue(jsonStr, A.class);
            System.out.println("a1 = " + a1);

            // write 是用于将java对象转化为字符串.
            System.out.println("a1 = " + objectMapper.writeValueAsString(a1));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class A {
        private String a;
        private String b;
    }
}
