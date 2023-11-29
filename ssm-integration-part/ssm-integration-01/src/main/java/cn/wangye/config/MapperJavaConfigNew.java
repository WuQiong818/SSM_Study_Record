package cn.wangye.config;


import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;

import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class MapperJavaConfigNew {


    //    将sqlSessionFactoryBean加入到ioc容器当中
//    mybatis -> sqlSessionFactoryBean[ioc] -> getObject() -> sqlSessionFactory
//    方法一：外部指定mybatis-config.xml[mybatis的配置 除了连接池和mapper的指定]
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        //实例化sqlSessionFactoryBean工厂
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        /*这里原先是通过读取配置文件获取的，现在进行一个一个配置，配置的有连接池信息和mybatis-config.xml文件信息*/
//        配置连接池
        sqlSessionFactoryBean.setDataSource(dataSource);

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLogImpl(Slf4jImpl.class);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
        sqlSessionFactoryBean.setConfiguration(configuration);

        sqlSessionFactoryBean.setTypeAliasesPackage("cn.wangye.pojo");

        /*   <plugins>
                <plugin interceptor="com.github.pagehelper.PageInterceptor">
                      <property name="helperDialect" value="mysql"/>
                </plugin>
             </plugins>
    */
        //配置文件不要慌，结构都是对应着的
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect","mysql");
        pageInterceptor.setProperties(properties);
        return sqlSessionFactoryBean;
    }

    //    将Mapper对象配置到ioc容器当中
//    Mapper代理兑现的factoryBean -> 指定一个包 -> mapper接口 -》 sqlSessionFactory -> sqlSession
//    -> getMapper -> mapper代理对象[ioc]
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        配置Mapper接口和xml文件所在的共同包
        mapperScannerConfigurer.setBasePackage("cn.wangye.mapper");
        return mapperScannerConfigurer;
    }
/*<configuration>
    <settings>
        <!-- 开启驼峰式映射-->
        <setting name="mapUnderscoreToCamelCase" value="true"/>
        <!-- 开启logback日志输出 || 原先也有日志输出，只不过是STDOUT_LOGGING 这个是mybatis自己提供的日志输出 -->
        <setting name="logImpl" value="SLF4J"/>
        <!--开启resultMap自动映射 -->
        <setting name="autoMappingBehavior" value="FULL"/>
    </settings>

    <typeAliases>
        <!-- 给实体类起别名 -->
                    <!--
    helperDialect：分页插件会自动检测当前的数据库链接，自动选择合适的分页方式。
    你可以配置helperDialect属性来指定分页插件使用哪种方言。配置时，可以使用下面的缩写值：
    oracle,mysql,mariadb,sqlite,hsqldb,postgresql,db2,sqlserver,informix,h2,sqlserver2012,derby
                （完整内容看 PageAutoDialect） 特别注意：使用 SqlServer2012 数据库时，
    https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md#%E5%A6%82%E4%BD%95%E9%85%8D%E7%BD%AE%E6%95%B0%E6%8D%AE%E5%BA%93%E6%96%B9%E8%A8%80
            -->
    </typeAliases>

    <plugins>
        <plugin interceptor="com.github.pagehelper.PageInterceptor">
            <property name="helperDialect" value="mysql"/>
        </plugin>
    </plugins>
<!-- 相比与原先的mybatis-config配置文件，这里少了Mybatis的开发环境配置（事务管理器以及连接池的信息）和mapper的配置
            在这里就全部交给Java类去配置了
-->
</configuration>*/

}
