package cn.wangye.controller;

import cn.wangye.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("data1")
    public List<User> list(){
        String sql = "select * from user;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

}
