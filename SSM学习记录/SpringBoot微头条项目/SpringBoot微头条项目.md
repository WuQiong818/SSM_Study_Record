# 1.基于SpringBoot搭建项目基础架构

### 1.数据库脚本执行

### 2.搭建SpringBoot工程

1. 导入依赖
   1. ```XML
      <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>3.0.5</version>
      </parent>
      
      
      
      <dependencies>
      
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-web</artifactId>
          </dependency>
      
          <!-- mybatis-plus  -->
          <dependency>
              <groupId>com.baomidou</groupId>
              <artifactId>mybatis-plus-boot-starter</artifactId>
              <version>3.5.3.1</version>
          </dependency>
      
          <!-- 数据库相关配置启动器 -->
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-jdbc</artifactId>
          </dependency>
      
          <!-- druid启动器的依赖  -->
          <dependency>
              <groupId>com.alibaba</groupId>
              <artifactId>druid-spring-boot-3-starter</artifactId>
              <version>1.2.20</version>
          </dependency>
      
          <!-- 驱动类-->
          <dependency>
              <groupId>mysql</groupId>
              <artifactId>mysql-connector-java</artifactId>
              <version>8.0.28</version>
          </dependency>
      
          <dependency>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
              <version>1.18.28</version>
          </dependency>
      
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-aop</artifactId>
          </dependency>
          
          <dependency>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-test</artifactId>
             <scope>test</scope>
          </dependency>
      
      </dependencies>
      
      
      <!--    SpringBoot应用打包插件-->
      <build>
          <plugins>
              <plugin>
                  <groupId>org.springframework.boot</groupId>
                  <artifactId>spring-boot-maven-plugin</artifactId>
              </plugin>
          </plugins>
      </build>
      ```
2. 编写yml文件
   1. ```YAML
      # server配置
      server:
        port: 8080
        servlet:
          context-path: /
      
      # 连接池配置
      spring:
        datasource:
          type: com.alibaba.druid.pool.DruidDataSource
          druid:
            url: jdbc:mysql:/localhost:3306//数据库名
            username: root
            password: 123456
            driver-class-name: com.mysql.cj.jdbc.Driver
      
      # mybatis-plus的配置
      mybatis-plus:
        type-aliases-package: com.atguigu.pojo
        global-config:
          db-config:
            logic-delete-field: isDeleted  #全局逻辑删除
            id-type: auto #主键策略自增长
            table-prefix: news_ # 设置表的前缀
      ```
3. 启动类和mybatis-plus插件配置

```Java
@SpringBootApplication
@MapperScan("cn.wangye.mapper")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @Bean//配置mybatis插件
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return interceptor;
    }

}
```

1. 登录拦截器设置 拦截器类实现HandlerInterceptor，然后再配置类中进行路径的设置；

# 异常记录

Invalid bound statement (not found): cn.wangye.mapper.HeadlineMapper.updateById

原因：使用mybaits-plus提供的updateById进行数据的记录更新时，mybatis自动会自动使用id作为查询字段，如果我们数据库中是uid或者hid的话，就会报此一个异常。

解决：在实体类的属性上指定@TableId注解，mysql-plus我们设置的id作为更新和查询的id.

# 项目总结

### 1.关于token和jwt实现

1. 令牌（Token）：在计算机领域，令牌是一种代表某种访问权限或身份认证信息的令牌。它可以是一串随机生成的字符或数字，用于验证用户的身份或授权用户对特定资源的访问。普通的令牌可能以各种形式出现，如访问令牌、身份令牌、刷新令牌等。

Token是一项规范和标准(接口)

  JWT(JSON Web Token)是具体可以生成,校验,解析等动作Token的技术(实现类)

1. jwt工作流程
   1. 用户提供其凭据（通常是用户名和密码）进行身份验证。
   2. 服务器对这些凭据进行验证，并在验证成功后创建一个JWT。
   3. 服务器将JWT发送给客户端，并客户端在后续的请求中将JWT附加在请求头或参数中。
   4. 服务器接收到请求后，验证JWT的签名和有效性，并根据JWT中的声明进行身份验证和授权操作
   5. **token一般被存储在请求头当中，我们通过@RequestHeader和request.getHeader()进行获取**
2. jwt数据组成和包含信息

​    JWT由三部分组成: header(头部).payload(载荷).signature(签名)

​    我们需要理解的是, jwt可以携带很多信息! 一般情况,需要加入:有效时间,签名秘钥,其他用户标识信息!

​    有效时间为了保证token的时效性,过期可以重新登录获取!

​    签名秘钥为了防止其他人随意解析和校验token数据!

​    用户信息为了我们自己解析的时候,知道Token对应的具体用户!

**注意点：** 后端返回的数据一般是多于接口文档中所规定的的数据，只能多返回不能少返回；

接受JSON类型的数据是需要定义实体类进行接受的。

数据库字符串拼接使用concat函数

当传入的数据为多个实体类的使用，如果向我们想要在sql语句中使用一定要用**#{对象.对象属性（省去get且第一个字母小写）}**

使用StringUtils.isEmpty和使用字符串isEmpty的区别？

1. 使用StringUtils需要导包
2. StringUtils.isEmpty会判断字符串长度为0和字符串为null的两种情况，并且都返回true;而字符串.isEmpty()只会进行字符串长度为0的判断，如果为null,会报NullPointerException
3. 向前端发送的数据Result一般是需要在后端通过map进行封住的，形成key-value的结构。
4. 最大的问题就是在接口前面不先想一想思路，一上来就沉到细节里面，要看到全局整体；