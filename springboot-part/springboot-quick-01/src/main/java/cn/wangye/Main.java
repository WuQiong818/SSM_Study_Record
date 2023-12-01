package cn.wangye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication //启动类的标识
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args); //自动创建ioc容器，启动tomcat
    }
}