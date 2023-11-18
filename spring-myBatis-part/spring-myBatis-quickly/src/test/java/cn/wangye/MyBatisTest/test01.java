package cn.wangye.MyBatisTest;

import cn.wangye.mapper.EmployeeMapper;
import cn.wangye.mapper.TeacherMapper;
import cn.wangye.mapper.UserMapper;
import cn.wangye.pojo.Employee;
import cn.wangye.pojo.Teacher;
import cn.wangye.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class test01 {
    SqlSession session = null;

    @BeforeEach
    public void beforeEach() throws IOException {
        String mybatisConfigFilePath = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession(true);
    }

    @AfterEach
    public void afterEach() {
        session.close();
    }


    @Test
    public void testSelectEmployee() throws IOException {

//        1.创建SqlSessionFactory对象
//        1.1 声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mybatis-config.xml";
//        1.2以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);
//        1.3基于读取Mybatis配置输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//       2.使用SqlSessionFactory对象开启一个会话
        SqlSession session = sessionFactory.openSession();

//        3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象（动态代理技术）
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
//        4.调用代理类方法触发对应的SQL语句
        Employee employee = employeeMapper.selectEmployee(1);
        System.out.println(employee);
//        5.关闭SqlSession
        session.commit();
        session.close();
    }


    /**
     * 场景:如何维护一个自定义增长的主键；
     * Mybatis是将自增主键的值设置到实体类对象中，而不是以Mapper接口方法返回值的形式返回。
     * 疑问：如何创建一个自动提交的session,对于DML语句，我们不需要手动commit
     *
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        String mybatisConfigFilePath = "mybatis-config.xml";//获取mybatis配置文件的配置
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);//读取mybatis配置文件，创建一个输出流
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//读取输出流，创建一个会话工厂
//        自动开启事务，但是不会自动提交事务
//        SqlSession session = sqlSessionFactory.openSession();
//        自动开启事务，自动提交事务，不需要进行手动提交；
        SqlSession session = sqlSessionFactory.openSession(true);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("andy");
        employee.setEmpSalary(11.11);
        System.out.println(employee.getEmpId11());
        int rowCount = mapper.insertEmployee(employee);
//        session.commit();
        System.out.println("rowCount" + rowCount);
        System.out.println(employee.getEmpId11());
        session.close();
    }


    //    手动维护一个非自增长类型的主键
    @Test
    public void test03() throws IOException {
        String mybatisConfigFilePath = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        String tId = UUID.randomUUID().toString().replace("-", "");
        Teacher teacher = new Teacher(tId, "zhangsan");
        int rowCount = mapper.insert(teacher);
        System.out.println(rowCount);
    }

    @Test
    public void test04() throws IOException {
        String mybatisConfigFilePath = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession(true);
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.setTName("lisi");
        int rowCount = mapper.insert(teacher);
        System.out.println(rowCount);
    }


    //    SQL练习测试:
    @Test
    public void test05() throws IOException {
        String mybatisConfigFilePath = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.insertUserByString("yunfei", "12121");

    }

    //    返回值类型为Map的测试
    @Test
    public void test07() {
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> map = employeeMapper.selectEmpNameAndMaxSalary();
        System.out.println(map.get("员工姓名"));
        System.out.println(map.get("员工工资"));
        System.out.println(map.get("部门平均工资"));


    }

    //    动态SQL语句 where-if
    @Test
    public void test08() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("tom");
        employee.setEmpSalary(2000.0);
        List<Employee> employeeList = mapper.selectEmployeeByCondition(employee);
        System.out.println(Arrays.toString(new List[]{employeeList}));
    }


    //    动态SQL语句 set if
    @Test
    public void test09() {
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setEmpName("tom");
        employee.setEmpSalary(100.0);
        employee.setEmpId(1);
        mapper.updateEmployeeDynamic(employee);
        List<Employee> employeeList = mapper.selectEmployeeByCondition(employee);
        System.out.println(Arrays.toString(new List[]{employeeList}));
    }


    //批量插入数据
    @Test
    public void test10() {
//        Employee w = new Employee("z", 1100.0);
//        Employee a = new Employee("h", 2100.0);
//        Employee n = new Employee("a", 3100.0);
//        Employee g = new Employee("n", 41000.0);
//        w.setEmpId(3);
//        a.setEmpId(4);
//        n.setEmpId(6);
//        g.setEmpId(18);
//        List<Employee> list = new ArrayList<>();
//        list.add(w);
//        list.add(a);
//        list.add(n);
//        list.add(g);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
//        int count = mapper.updateBatch(list);
//        System.out.println("count="+count);
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(4);
        nums.add(6);
        nums.add(18);

        List<Employee> employees = mapper.queryBatch(nums);
        System.out.println(employees);
    }

    @Test
    public void test11() {
        EmployeeMapper mapper = session.getMapper(cn.wangye.mapper.EmployeeMapper.class);
        PageHelper.startPage(1, 4);
        List<Employee> list = mapper.selectEmployeeByCondition(new Employee());

        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        System.out.println("pageInfo=" + pageInfo);

        long total = pageInfo.getTotal();//获取总记录的条数
        System.out.println("total=" + total);
        int pages = pageInfo.getPages();//获取总页数
        System.out.println("pages=" + pages);
        int pageNum = pageInfo.getPageNum();//获取当前页码
        System.out.println("pageNum=" + pageNum);
        int pageSize = pageInfo.getPageSize();//获取每页显示的记录数
        System.out.println("pageSize=" + pageSize);
        List<Employee> infoList = pageInfo.getList();//获取查询页的数据集合
        System.out.println("infoList=" + infoList);
    }
/*    pageInfo=
    PageInfo{pageNum=1, pageSize=2, size=2, startRow=1, endRow=2, total=4, pages=2,
                list=Page{count=true, pageNum=1, pageSize=2, startRow=0, endRow=2, total=4, pages=2, reasonable=false, pageSizeZero=false}
                    [Employee{empId=3, empName='z', empSalary=1100.0}, Employee{empId=4, empName='h', empSalary=2100.0}],
                        prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true, navigatePages=8, navigateFirstPage=1, navigateLastPage=2, navigatepageNums=[1, 2]}*/

    @Test
    public void test12(){
        int i;
        User user;
        user = new User();
        user.getId();
        System.out.println(1);
    }
}

















































