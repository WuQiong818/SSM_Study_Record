package cn.wangye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping("data1")
    public String data1(){
        String str = null;
        str.toString();//模拟空指针异常
        return"notPoint";
    }
    
    @RequestMapping("data2")
    public String data2(){
        int num = 1/0; //模拟除0异常
        return "/";
    }

}
