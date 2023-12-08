package cn.wangye.json;

import cn.wangye.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("json")
public class JSONController {
    @GetMapping("data1")
    public User data1(){
        System.out.println("data1");
        User user = new User("two dogs", 21);
        return user;
    }

    @ResponseBody
    @GetMapping("data2")
    public List<User> data2(){
        System.out.println("data2");
        User user = new User("two dogs", 21);
        List<User> list = new ArrayList<>();
        list.add(user);
        return list;
    }


}
