package cn.wangye.ioc4MVC.dao;

import cn.wangye.ioc4MVC.pojo.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface StudentDao {
    /**
     * 查询全部学生数据
     *
     * @return
     */
    List<Student> queryAll();


}
