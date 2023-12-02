package cn.wangye.controller;

import cn.wangye.pojo.DataSourceInfo;
import cn.wangye.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private User user = new User();

    @GetMapping("query")
    public User query() {
        System.out.println(user.toString());
        return user;
    }

    @Autowired
    private DataSourceInfo dataSourceInfo;

    @GetMapping("data")
    public DataSourceInfo queryInfo() {
        System.out.println(dataSourceInfo.toString());
        return dataSourceInfo;
    }
}
