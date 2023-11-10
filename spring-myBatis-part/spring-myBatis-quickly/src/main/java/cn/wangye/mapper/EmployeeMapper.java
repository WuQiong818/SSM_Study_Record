package cn.wangye.mapper;

import cn.wangye.pojo.Employee;

/**
 * t_emp表对应数据库SQL语句映射接口!
 *    接口只规定方法,参数和返回值!
 *    mapper.xml中编写具体SQL语句!
 */
public interface EmployeeMapper {

    /**
     * 根据员工id查询员工数据方法
     * @param empId  员工id
     * @return 员工实体对象
     */
    //接口方法,在MyBatis环境下，我们不需要再进行实现类的书写,我们需要做的就是写好接口和接口对应的配置文件
    public Employee selectEmployee(Integer empId);
    
}