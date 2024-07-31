package com.uni.framework;

import lombok.Data;
import lombok.ToString;

import java.util.Arrays;

@ToString
public enum ColorEnum {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    ColorEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
    public static String getName(int index) {
        for (ColorEnum c : ColorEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }

    public static void main(String[] args) {
        Enum e = ColorEnum.RED;
        ColorEnum red = ColorEnum.valueOf("RED");
        System.out.println(red.getName());
        System.out.println("red = " + red.getIndex());
        ColorEnum g = ColorEnum.valueOf("GREEN");
        System.out.println(g.getName());
        System.out.println("red = " + g.getIndex());

        Arrays.stream(ColorEnum.values()).forEach(System.out::println);


        switch (ColorEnum.valueOf("RED")    ) {
            case RED:
                System.out.println("red");
                break;
            case GREEN:
                System.out.println("green");
                break;
            case BLANK:
                System.out.println("blank");
                break;
            case YELLO:
                System.out.println("yello");
                break;
            default:
                System.out.println("other");
                break;
        }
    }
}
