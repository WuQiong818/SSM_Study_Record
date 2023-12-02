package cn.wangye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication //启动类的标识
public class Main {
    public static void main(String[] args) {
        //自动创建ioc容器，启动tomcat
        SpringApplication.run(Main.class,args);
    }
}