package cn.wangye.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("cn.wangye")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement//开启事务注解的支持
//@EnableAspectJAutoProxy //开启AOP注解的支持
public class MyConfig {
    //    读取配置文件
    @Value("${test.url}")
    private String url;

    @Value("${test.driver}")
    private String driver;

    @Value("${test.username}")
    private String username;

    @Value("${test.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    /**
     * 装配事务管理实现对象
     * @param dataSource 数据源
     * @return 返回事务管理实现对象
     */
    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        //事务管理器内部要进行事务的操作，基于的连接池;
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        //传入我们的连接池对象
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
