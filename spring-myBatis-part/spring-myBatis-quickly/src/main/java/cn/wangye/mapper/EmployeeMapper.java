package cn.wangye.mapper;

import cn.wangye.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * t_emp表对应数据库SQL语句映射接口!
 * 接口只规定方法,参数和返回值!
 * mapper.xml中编写具体SQL语句!
 */
public interface EmployeeMapper {

    /**
     * 根据员工id查询员工数据方法
     *
     * @param empId 员工id
     * @return 员工实体对象
     */
    //接口方法,在MyBatis环境下，我们不需要再进行实现类的书写,我们需要做的就是写好接口和接口对应的配置文件
    public Employee selectEmployee(Integer empId);

    public int insertEmployee(Employee employee);

    public int insertNoAutocommitEmployee(Employee employee);

    //    类型设计的不一样，map对应的value是Object类型的数据;
    Map<String, Object> selectEmpNameAndMaxSalary();

    //    根据参数employee的条件去查询对应的数据信息
    List<Employee> selectEmployeeByCondition(Employee employee);

    void updateEmployeeDynamic(Employee employee);

    //   ------------------批量操作学习-----------------------
    //    批量增加数据
    int insertBatch(@Param("list") List<Employee> list);

    //    批量删除数据
    int deleteBatch(@Param("ids") List<Integer> ids);

    //    批量更改数据
    int updateBatch(@Param("list") List<Employee> list);

    //    批量查询数据
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);


}