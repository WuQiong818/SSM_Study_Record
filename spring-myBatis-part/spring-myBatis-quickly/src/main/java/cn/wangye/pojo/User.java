package cn.wangye.pojo;

import lombok.Data;

import java.io.Serializable;

//lombok插件使用的时候，不仅仅要安装对应的插件，也要引入lombok.jar包
//使用：@Data 相当于自动为我们的类安装了 get set toString

@Data //lombok插件
public class User {
  private Integer id;
  private String username;
  private String password;
}