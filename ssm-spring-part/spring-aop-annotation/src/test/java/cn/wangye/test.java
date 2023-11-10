package cn.wangye;

import cn.wangye.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


//@SpringJUnitConfig(locations = {"classpath:spring-context.xml"})//指定配置文件XML
@SpringJUnitConfig(value = {JavaConfig.class})//指定配置类
public class test {


//    如果我们有接口，这里取值的时候，直接用接口取值，防止我们取不到代理对象；

    @Autowired
    private Calculator calculator;

    @Test
    public void test01(){
        System.out.println( calculator.add(1,1));
    }
}
