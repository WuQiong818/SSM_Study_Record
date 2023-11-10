package cn.wangye.dao.impl;

import cn.wangye.dao.StudentDao;
import cn.wangye.poji.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Student selectById(int id) {
        Student student = new Student();
        String sql = "select * from students where id = ?;";
        jdbcTemplate.queryForObject(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                student.setClasses(rs.getString("class"));
                return student;
            }
        },id);
        return student;
    }

    @Override
    public List<Student> selectAll() {
        String sql = "select id,name,gender,age,class as classes from students; ";
        List<Student> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<Student>(Student.class));
        return list;
    }
}
