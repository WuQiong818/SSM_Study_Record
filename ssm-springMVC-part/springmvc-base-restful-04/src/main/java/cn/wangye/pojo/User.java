package cn.wangye.pojo;

import lombok.Data;

@Data
public class User {
    private String name;
    private int age;
    private String hobby;

    public User() {
    }

    public User(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }
}
