package cn.wangye.service.Impl;
//pull update!!
import cn.wangye.mapper.EmployeeMapper;
import cn.wangye.pojo.Employee;
import cn.wangye.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> queryEmpAll() {
        List<Employee> list = employeeMapper.queryEmployeeAll();
        return list;
    }
}
