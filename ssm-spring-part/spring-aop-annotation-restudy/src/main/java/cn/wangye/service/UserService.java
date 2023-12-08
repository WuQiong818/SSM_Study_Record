package cn.wangye.service;

import org.springframework.stereotype.Service;


@Service
public class UserService {

    public void getUserList() {
        System.out.println("方法内部 com.atguigu.aop.imp.EmployeeService.getEmpList");
    }

}
