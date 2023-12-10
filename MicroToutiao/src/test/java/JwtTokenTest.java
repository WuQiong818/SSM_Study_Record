import cn.wangye.Main;
import cn.wangye.utils.JwtHelper;
import com.alibaba.druid.util.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest(classes = Main.class)
public class JwtTokenTest {

    @Autowired
    private JwtHelper jwtHelper;

    @Test
    public void test01(){
        String token = jwtHelper.createToken(1L);
        System.out.println("token"+token);

        int userId = jwtHelper.getUserId(token).intValue();
        System.out.println("useId"+userId);

        boolean expiration = jwtHelper.isExpiration(token);
        System.out.println(expiration);
        
    }

    @Test
    public void test02(){
        String str = null;
        System.out.println(StringUtils.isEmpty(str));
        System.out.println(str.isEmpty());
    }

//    获取日期时间

    @Test
    public void test03(){
        System.out.println(new Date(System.currentTimeMillis()));
//        2023-06-25 09:35:43
        System.out.println(new Date()); //Sat Dec 09 21:54:08 CST 2023
    }

}
