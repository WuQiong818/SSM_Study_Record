package test;


import cn.wangye.Main;
import cn.wangye.mapper.UserMapper;
import cn.wangye.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@SpringBootTest(classes = Main.class)
//@ContextConfiguration//使用这一个可以，但是不会自动将测试类进行装载了
public class Test01 {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println("------selectALL method-----");
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }


}
