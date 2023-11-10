package cn.wangye.ioc1;


import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("cn.wangye.ioc1")
//使用注解读取外部配置，替代  <context:property-placeholder location="classpath:jdbc.properties"/>标签
@PropertySource("classpath:jdbc.properties")//里面是一个字符串，classpath路径下的xxxx.properties
public class MyConfiguration {



}
