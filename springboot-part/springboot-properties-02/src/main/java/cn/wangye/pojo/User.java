package cn.wangye.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
//@ConfigurationProperties(prefix = "user.info")
public class User {
//    @Value("${user.info.name}")
    private String name;
//    @Value("${user.info.password}")
    private String password;

    private List<String> hobby;
//    @Value("${user.age}")
    private int age;
}
