package cn.wangye.advice;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
//    *表示通配符 路径依次为:所有该模块下，以cn.wangye.service.impl为前缀的路径，该包下所有的类中所有的方法
    @Before("execution(* cn.wangye.service.impl.*.*(..))")
    public void start(){
        System.out.println("方法开始了");
    }


   @AfterReturning("execution(* cn.wangye.service.impl.*.*(..))")
    public void end() {
        System.out.println("方法结束了");
    }

    @AfterThrowing("execution(* cn.wangye.service.impl.*.*(..))")
    public void error(){
        System.out.println("方法执行错误，报异常了");
    }



}
