package cn.wangye.ioc4MVC.dao.Impl;

import cn.wangye.ioc4MVC.dao.StudentDao;
import cn.wangye.ioc4MVC.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Student> queryAll() {
        String sql = "select id,name,gender,age,class as classes from students;";
        List<Student> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
        return list;
    }
}
