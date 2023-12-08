package cn.wangye;


import cn.wangye.pojo.User;
import jakarta.ws.rs.Path;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController //@RestController = @ResponseBody + @Controller
@RequestMapping("user")
public class UserController {

    @GetMapping//不写路径，直接继承父路径的地址
    public List<User> usersPage(@RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int size) {
//        这里如何使用list去模拟分页查询呢？
        List<User> list = new ArrayList<>();
        for (int i = (page - 1) * size; i < page * size; i++) {
            System.out.println(i);
        }
        return list;
    }


    @PostMapping
    public String addUser(@RequestBody User user) {
        System.out.println(user.toString());
        return "user add success";
    }

    @GetMapping("{id}")
    public User queryUserById(@PathVariable int id) {
        System.out.println(id);
        User user = new User("wang", 21, "sleepy");
        return user;
    }

    @PutMapping
    public String updateUser(@RequestBody User user) {
        System.out.println(user);
        return "user update success";
    }

    @DeleteMapping("{id}")
    public String deleteUserById(@PathVariable int id) {
        System.out.println(id);
        return "user delete success";
    }

    @GetMapping("search")
    public List<User> queryByKeyword(String keyword,//可传可不传，但是没有默认值了
                                     @RequestParam(required = false, defaultValue = "1") int page,
                                     @RequestParam(required = false, defaultValue = "10") int size) {

        List<User> list = new ArrayList<>();
        return list;

    }

}


























































