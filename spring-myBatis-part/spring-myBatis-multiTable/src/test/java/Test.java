import cn.wangye.mapper.OrderMapper;
import cn.wangye.pojo.Customer;
import cn.wangye.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.io.InputStream;

public class Test {
    SqlSession session = null;

    @BeforeEach
    public void beforeEach() throws IOException {
        String mybatisConfigFileName = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFileName);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession(true);
    }
    @AfterEach
    public void afterEach(){
//        如果我们的session需要进行手动提交
//        session.commit();
        session.close();
    }

    @org.junit.jupiter.api.Test
    public void test01(){
//        这个路径要不写全类名，要不就需要导包，寻找与匹配原则
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Order order = mapper.selectOrderWithCustomer(1);
        System.out.println(order);

    }

    @org.junit.jupiter.api.Test
    public void test02(){
//        这个路径要不写全类名，要不就需要导包，寻找与匹配原则
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Customer customer = mapper.selectCustomerWithOrder(1);
        System.out.println(customer);

    }


}
