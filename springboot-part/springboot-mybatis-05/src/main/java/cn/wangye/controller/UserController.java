package cn.wangye.controller;

import cn.wangye.mapper.UserMapper;
import cn.wangye.pojo.User;
import cn.wangye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("list")
    public List<User> list() {
        return userMapper.queryList();
    }


    @Autowired
    private UserService userService;

    @RequestMapping("delete/{id}")
    public int deleteById(@PathVariable Integer id) {
        int result = userService.deleteUserById(id);
        return result;
    }

}
