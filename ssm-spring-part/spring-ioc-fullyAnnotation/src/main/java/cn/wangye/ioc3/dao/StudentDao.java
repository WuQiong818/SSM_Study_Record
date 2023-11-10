package cn.wangye.ioc3.dao;

import cn.wangye.ioc3.pojo.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 查询全部学生数据
     * @return
     */
    List<Student> queryAll();
}