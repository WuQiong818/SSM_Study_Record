import cn.wangye.poji.Student;
import cn.wangye.servlet.StudentServlet;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MVCTest {


    @Test
    public void main() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("MVCTest.xml");
        StudentServlet servlet = context.getBean("studentServlet", StudentServlet.class);
        Student student = servlet.selectById(1);
        System.out.println(student);
        List<Student> list = servlet.selectAll();
        System.out.println(list);
    }
}
