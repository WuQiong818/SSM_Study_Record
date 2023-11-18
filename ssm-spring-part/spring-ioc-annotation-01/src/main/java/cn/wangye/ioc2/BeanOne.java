package cn.wangye.ioc2;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BeanOne {

    //周期方法要求： 方法命名随意，但是要求方法必须是 public void 无形参列表
    @PostConstruct  //注解制指定初始化方法 构造后执行的方法就是初始化的周期方法;
    public void init() {
        // 初始化逻辑
        System.out.println("init-method执行了");
    }


    @PreDestroy //注解指定销毁方法 销毁前执行的周期方法;
    public void cleanup() {
        // 释放资源逻辑
        System.out.println("destroy-method执行了");

    }
}