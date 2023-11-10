package cn.wangye.ioc2;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan("cn.wangye.ioc2")
@PropertySource("classpath:jdbc.properties")
public class MyConfiguration {
    @Value("${test.url}")
    private String url;

    @Value("${test.driver}")
    private String driver;

    @Value("${test.username}")
    private String username;

    @Value("${test.password}")
    private String password;

    /*
    我们在自己写的组件类当中可以通过@Component这一系列注解进行引入，
    但是对于第三方jar包，我们只有阅读的权限，没有办法进行修改、添加的操作
    所以，我们需要通过类一种注解方法，来完成第三方jar包向ioc容器中添加的操作
    这一个方法就是@Bean

    //如果第三方类进行IoC管理,无法直接使用@Component相关注解
    //解决方案: xml方式可以使用<bean标签
    //解决方案: 配置类方式,可以使用方法返回值+@Bean注解

   */
    @Bean
    public DruidDataSource dataSource1() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DruidDataSource dataSource2() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate() {
        /*
        * 在一个 @Bean 方法中直接调用其他 @Bean 方法来获取 Bean 实例，
        * 虽然是方法调用，也是通过IoC容器获取对应的Bean*/
        JdbcTemplate jdbcTemplate1 = new JdbcTemplate(dataSource1());
        return jdbcTemplate1;

    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource1) {
        JdbcTemplate jdbcTemplate2 = new JdbcTemplate(dataSource1);
        return jdbcTemplate2;
    }


}

















































