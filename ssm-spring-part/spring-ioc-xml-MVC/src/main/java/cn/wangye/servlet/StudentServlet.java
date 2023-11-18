package cn.wangye.servlet;

import cn.wangye.poji.Student;
import cn.wangye.service.StudentService;

import java.util.List;

public class StudentServlet {
    StudentService studentService ;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student selectById(int id){
        return studentService.selectById(id);
    }

    public List<Student> selectAll(){
        return studentService.selectByAll();
    }


}
