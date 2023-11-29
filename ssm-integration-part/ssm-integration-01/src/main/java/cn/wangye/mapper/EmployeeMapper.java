package cn.wangye.mapper;

import cn.wangye.pojo.Employee;
import jakarta.ws.rs.BeanParam;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> queryEmployeeAll();
}
