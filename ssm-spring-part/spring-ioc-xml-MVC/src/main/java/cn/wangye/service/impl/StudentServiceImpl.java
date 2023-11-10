package cn.wangye.service.impl;

import cn.wangye.dao.StudentDao;
import cn.wangye.dao.impl.StudentDaoImpl;
import cn.wangye.poji.Student;
import cn.wangye.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student selectById(int id) {
        Student student = studentDao.selectById(id);
        return student;
    }

    @Override
    public List<Student> selectByAll() {
        List<Student> list = studentDao.selectAll();
        return list;
    }
}
