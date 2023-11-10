import cn.wangye.config.MyConfig;
import cn.wangye.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(MyConfig.class)
public class TxTest {
    @Autowired
    private StudentService studentService;
    @Test
    public void testTx(){
        studentService.changeInfo();
    }
}
