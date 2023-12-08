package cn.wangye.pojo;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;


@Data
public class User {

    @NotEmpty
    private String name;

    @Min(20)
    private Integer age;

    @Email
    private String mailbox;

    @Min(6)
    private String password;

    @Past
    private Date birthday;
}
