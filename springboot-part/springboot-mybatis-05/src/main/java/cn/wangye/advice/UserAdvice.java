package cn.wangye.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.JobName;

@Component
@Aspect
@Order(5) //value越小优先级越高
public class UserAdvice {
    @Pointcut("execution(* cn.wangye.service.UserService.deleteUserById(Integer))")
    public void deletePointCut(){}


    @Before(value = "deletePointCut()")
    public void before(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[前置通知]");
        System.out.println(className+"类的"+methodName+"方法执行了");
    }
}
