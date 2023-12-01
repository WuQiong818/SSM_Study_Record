package cn.wangye.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
public class MapperJavaConfig {

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
//        设置配置文件
//        包裹外部覆盖配置文件地址对象
        Resource resource = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);
        return sqlSessionFactoryBean;
    }

//    将Mapper对象配置到ioc容器当中
//    Mapper代理兑现的factoryBean -> 指定一个包 -> mapper接口 -》 sqlSessionFactory -> sqlSession
//    -> getMapper -> mapper代理对象[ioc]
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        配置Mapper接口和xml文件所在的共同包
       mapperScannerConfigurer.setBasePackage("cn.wangye.mapper");
        return mapperScannerConfigurer;

    }



























}
