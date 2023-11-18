package cn.wangye.service;

import cn.wangye.dao.StudentDao;
import cn.wangye.dao.impl.StudentDaoImpl;
import cn.wangye.poji.Student;

import java.util.List;

public interface StudentService {

    public Student selectById(int id);

    public List<Student> selectByAll();
}
