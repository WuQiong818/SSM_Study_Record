package cn.wangye.controller;


import cn.wangye.pojo.User;
import cn.wangye.service.UserService;
import cn.wangye.utils.JwtHelper;
import cn.wangye.utils.Result;
import cn.wangye.utils.ResultCodeEnum;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin//解决跨域请求
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("login")
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }


    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token) {//请求头就写请求头，请求体就写请求体
        System.out.println("token=" + token);
        return userService.getUserInfo(token);
    }

    @PostMapping("checkUserName")
    public Result checkUserName(String username) {
        return userService.checkUserName(username);
    }

    @PostMapping("regist")
    public Result register(@RequestBody User user){
        System.out.println(user.toString());
        return userService.register(user);
    }

    @GetMapping("checkLogin")
    public Result checkLogin(@RequestHeader String token){
        if(!StringUtils.isEmpty(token) && !jwtHelper.isExpiration(token)){
            return Result.ok(null);
        }else {
            return Result.build(null,ResultCodeEnum.NOTLOGIN);
        }
    }
}
