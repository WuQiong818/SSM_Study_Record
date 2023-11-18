package cn.wangye;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("cn.wangye")
@EnableAspectJAutoProxy
//以上配置，等同于在xml文件中配置<aop:aspectj-autoproxy/>
public class JavaConfig {

}
