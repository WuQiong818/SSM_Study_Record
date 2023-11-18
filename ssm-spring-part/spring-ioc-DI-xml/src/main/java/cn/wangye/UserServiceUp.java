package cn.wangye;

public class UserServiceUp {
    private UserDao userDao;

    private int age;

    private String name;

    public UserServiceUp(int age , String name ,UserDao userDao) {
        this.userDao = userDao;
        this.age = age;
        this.name = name;
    }
}
