package cn.wangye.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("cn.wangye")
@EnableAspectJAutoProxy // 配置类上开启 Aspectj注解支持!
public class MyConfig {

}
