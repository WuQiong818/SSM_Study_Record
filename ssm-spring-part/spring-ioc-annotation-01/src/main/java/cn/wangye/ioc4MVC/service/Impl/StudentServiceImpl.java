package cn.wangye.ioc4MVC.service.Impl;

import cn.wangye.ioc4MVC.dao.StudentDao;
import cn.wangye.ioc4MVC.pojo.Student;
import cn.wangye.ioc4MVC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
//   你仅仅需要做的就是保证当前类在IOC容器当中，并且StudentDao类也在容器当中，你仅仅需要进行@Autowired标记即可。
    @Override
    public List<Student> selectAll() {
        return studentDao.queryAll();
    }
}
