package cn.wangye.controller;

import cn.wangye.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
@ResponseBody
public class UserController {
    @RequestMapping("data1")
    public String data1() {
        System.out.println("data1执行了");
        return "data1";
    }


    @RequestMapping("data2")
    public String data2() {
        System.out.println("data2执行了");
        return "data2";
    }

    @RequestMapping("register")
    public Object register(@RequestBody @Validated User user,BindingResult result) {
        if (result.hasErrors()){
            System.out.println("错误");
            String errorMsg = result.getFieldError().toString();

            return errorMsg;
        }
        System.out.println("正常");
        return user;
    }
}
