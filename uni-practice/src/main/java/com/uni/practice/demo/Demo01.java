package com.uni.practice.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class StreamApplicationTests {


    public static List<User>  initUserList(){
        List<User> list = new ArrayList<>();
        list.add(new User("xiaoHu", 150000,  24, "man","Henan","Zhengzhou","Erqi"));
        list.add(new User("LetMe", 160000,  27, "man","Zhejiang","Hangzhou","Xihu"));
        list.add(new User("Mlxg", 170000,  26, "man","Shandong","Jinan","Qianfoshan"));
        list.add(new User("xiaoMing", 160000,  25, "man","Jiangsu","Nanjing","Yuhuatai"));
        list.add(new User("Miss", 180000,  18, "women","Henan","Zhoukou","chuanhuiqu"));
        list.add(new User("Uzi", 200000, 23, "man","Shandong","Qingdao","Laoshan"));
        return list;
    }


    static List<User> initUserList2(){
        List<User> list = new ArrayList<>();
        list.add(new User("xiaoHu", 150000,  24, "man","Henan","Zhengzhou","Erqi"));
        list.add(new User("Gala", 160000,  27, "man","Zhejiang","Hangzhou","Xihu"));
        list.add(new User("Wei", 170000,  26, "man","Shandong","Jinan","Qianfoshan"));
        list.add(new User("xiaoMing", 160000,  25, "man","Jiangsu","Nanjing","Yuhuatai"));
        list.add(new User("YuShuang", 180000,  18, "women","Henan","Zhoukou","chuanhuiqu"));
        list.add(new User("Cryin", 200000, 23, "man","Shandong","Qingdao","Laoshan"));
        return list;
    }


    public static void main(String[] args) {
        List<User> users = initUserList();
        //队员薪资大于160000的打印出来信息
        users.stream().filter(u->u.getSalary()>160000).forEach(System.out::println);
        //队员薪资大于160000的第一个用户的信息
        Optional<User> first = users.stream().filter(u -> u.getSalary() > 160000).findFirst();
        //队员薪资大于160000的任意一个用户信息
        Optional<User> any = users.stream().filter(u -> u.getSalary() > 160000).findAny();

        System.out.println("薪资大于160000的第一个用户的信息" + first.get());

        int sum = users.stream().sorted(Comparator.comparingInt(User::getSalary)).mapToInt(User::getSalary).sum();
        // 统计总和.
        System.out.println("sum = " + sum);
    }
        //System.out.println("薪资大于160000的任意一个用户信息" + any.get());
}
@Data
class User {
    private String name;
    private int salary;
    private int age;
    private String gender;
    private String province;
    private String city;
    private String district;

    public User(String name, int salary, int age, String gender, String province, String city, String district) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
        this.province = province;
        this.city = city;
        this.district = district;
    }
}