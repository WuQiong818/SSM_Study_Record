package cn.wangye.service;

import cn.wangye.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    @Transactional
    public void changeInfo() {
        studentDao.updateAgeById(9, 1);
        System.out.println("-----------");
        int i = 1/0;
        studentDao.updateNameById("test1", 1);
    }
}
