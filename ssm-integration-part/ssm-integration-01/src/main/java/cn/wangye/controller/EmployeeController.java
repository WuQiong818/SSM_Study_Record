package cn.wangye.controller;

import cn.wangye.mapper.EmployeeMapper;
import cn.wangye.pojo.Employee;
import cn.wangye.service.EmpService;
import cn.wangye.service.Impl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//ResponseBody Controller
@RequestMapping("emp")
public class EmployeeController {
    @Autowired
    private EmpService empService;
    @RequestMapping("find")
    public List<Employee> queryEmployeeAll(){
        List<Employee> list = empService.queryEmpAll();
        return list;
    }
}
