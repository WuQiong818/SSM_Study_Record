package cn.wangye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping("spring")
    public String hello(){
        System.out.println("Hello-SpringBoot3!!");
        return "Hello-SpringBoot3!!";
    }
}

/*
* 创建SpringBoot项目的流程：
* 1.创建Maven工程
* 2.添加依赖（springboot父工程依赖，web启动器依赖）
* 3.编写启动器引导类（springboot项目运行的入口）@SpringBootApplication
* 4.编写处理器Controller，约定大于注解，只要放到根路径下就可以被扫描到
* 5.启动项目
* 感受:真轻便和帅气。
* */
