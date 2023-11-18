import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;



public class TraditionForJava {
    @Test
    public  void test(String[] args) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/studb");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //实例化对象即可
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

//        我们如何使用Spring给我们提供的模板呢？
//        jdbcTemplate.update(); DDL DML DCL非查询操作都可以进行实现
//        jdbcTemplate.queryForObject(); //DQL查询单个对象
//        jdbcTemplate.query(); DQL查询集合
    }
}
