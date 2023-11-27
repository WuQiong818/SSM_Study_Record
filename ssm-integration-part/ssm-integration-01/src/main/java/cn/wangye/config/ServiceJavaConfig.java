package cn.wangye.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/*
* 1. service
* 2. 开启aop注解的支持，aspect:@Before @After @AfterReturning @AfterThrowing @round @Aspect @Order
* 3. tx声明式事务管理 1.对应事务管理器的实现 2. 开始事务注解支持 @Transactional
*
* */


@Configuration
@ComponentScan("cn.wangye.service")
//这是业务层配置独有的两个注解，一个是允许事务，一个是aop切面
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class ServiceJavaConfig {
    @Bean//实现对应的事务管理器。TransactionManager -DataSource-Hibernate-Jpa
    public TransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
