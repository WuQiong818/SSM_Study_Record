package cn.wangye.ioc3.service.Impl;

import cn.wangye.ioc3.dao.StudentDao;
import cn.wangye.ioc3.pojo.Student;
import cn.wangye.ioc3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public List<Student> findAll() {

        List<Student> studentList =  studentDao.queryAll();

        return studentList;
    }
}
