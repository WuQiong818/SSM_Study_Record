import cn.wangye.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void testDML(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc-xml-exercise.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "insert into students (name,gender,age,class) values (?,?,?,?);";
//        varchar类型的数据要当成String进行处理
        int count = jdbcTemplate.update(sql, "liSi","男",21, "高中二班");
        if (count==1){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }

    }

    @Test
    public void testDQLForObject(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc-xml-exercise.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select * from students where id =?;";

//        如果我们这里使用RowMapper，需要自己去实现RowMapper接口中的方法，完成查询到的数据库列与Java类的映射关系
//        我们也可以
        jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                student.setClasses(rs.getString("class"));
                System.out.println(student);
                return student;
            }
        }, 9);


        sql="select id,name,gender,age,class as classes from students;";
        List<Student> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println(list);
    }

}
