package cn.wangye;

import cn.wangye.config.MyConfig;
import cn.wangye.service.Calculator;
import cn.wangye.service.MerchandiseService;
import cn.wangye.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
@SpringJUnitConfig(value = {MyConfig.class})
public class Test {

    @Autowired
    private Calculator calculator;

    @org.junit.jupiter.api.Test
    public void test01(){
        calculator.add(1,1);
    }


    @Autowired
    private UserService userService;

    @org.junit.jupiter.api.Test
    public void test02(){
        userService.getUserList();
    }


    @Autowired
    private MerchandiseService merchandiseService;
    @org.junit.jupiter.api.Test
    public void test03(){
        merchandiseService.getList();
    }

}
