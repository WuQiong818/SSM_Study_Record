package cn.wangye.dao;

import cn.wangye.poji.Student;

import java.util.List;

public interface StudentDao {
    public Student selectById(int id);

    public List<Student> selectAll();
}
