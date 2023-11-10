package cn.wangye.ioc4MVC.servlet;


import cn.wangye.ioc4MVC.pojo.Student;
import cn.wangye.ioc4MVC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private StudentService studentService;//根据接口找实现类

    public List<Student> selectAll(){
        return studentService.selectAll();
    }
}
