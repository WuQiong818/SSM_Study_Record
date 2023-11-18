package cn.wangye.advice;

/*
* 如何配置增强类:
* 1.在配置类上加注解，放入IOC容器中和指定为切面类
* 2.书写普通的增强方法，几个位置，写几个增加方法，并在相应的增强方法上进行注解的标记，什么时候执行这些方法
* */


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

@Component
@Aspect
public class MyAdvice {
    @Before("execution(* cn.wangye.service.impl.*.*(..))")//切点表达式？
    public void before(JoinPoint joinPoint){
//        通过JoinPoint对象获取目标方法签名签名对象，方法的签名，一个方法的全部声明信息;签名对象就是signature
//        获取方法所属的类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
//        获取方法名
        String name = joinPoint.getSignature().getName();
//        获取参数
        Object[] args = joinPoint.getArgs();

//        获取访问修饰符
        int modifiers = joinPoint.getSignature().getModifiers();
        String str = Modifier.toString(modifiers);
    }

    @AfterReturning(value = "execution(* cn.wangye.service.impl.*.*(..))",returning = "result")
    public void afterReturning(Object result){

    }



    @After("execution(* cn.wangye.service.impl.*.*(..))")
    public void after(){
        int [] array = {3,1,2};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    @AfterThrowing(value = "execution(* cn.wangye.service.impl.*.*(..))",throwing = "t")
    public void afterThrowing(Throwable t){


    }
}
