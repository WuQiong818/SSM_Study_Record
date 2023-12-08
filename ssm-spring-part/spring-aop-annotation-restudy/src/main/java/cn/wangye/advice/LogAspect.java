package cn.wangye.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect //标注这个类是一个切面类

@Component//放入IOC容器中，让ioc容器进行管理并且方便装配
public class LogAspect {

    @Before(value = "execution(* cn.wangye.service.UserService.*(..))")
    // value属性：指定切入点表达式，由切入点表达式控制当前通知方法要作用在哪一个目标方法上
    public void printLogBeforeCore(JoinPoint joinPoint) {
//        joinPoint获取的实体切点表达式对应的接口
        System.out.println("什么是方法签名");
        System.out.println("joinPoint = "+joinPoint);
        Signature signature = joinPoint.getSignature();
        System.out.println("signature = "+ signature);

        System.out.println("methodName = " + signature.getName());
        System.out.println("modifiers = " + signature.getModifiers());
        System.out.println("declaringTypeName = " + signature.getDeclaringTypeName());
        System.out.println("simpleName = "+ joinPoint.getTarget().getClass().getSimpleName());
        System.out.println(Arrays.asList(joinPoint.getArgs()));//数组形式，直接打印看不出来
        System.out.println("[AOP前置通知]方法开始了");
    }

//    @AfterReturning(value = "cn.wangye.pointcut.MyPointcut.GlobalPointCut()",
//    returning = "targetMethodReturnValue")
    public void printLogAfterSuccess(JoinPoint joinPoint,Object targetMethodReturnValue) {
        System.out.println("[AOP返回通知] 方法成功返回了");
        System.out.println(joinPoint.getSignature().getName()+"方法返回的值为"+targetMethodReturnValue);
    }

//    @AfterThrowing(value = "cn.wangye.pointcut.MyPointcut.GlobalPointCut()",
//    throwing = "targetMethodException")
    public void printLogAfterException(JoinPoint joinPoint,Throwable targetMethodException) {
        System.out.println("[AOP异常通知] 方法抛异常了");
        System.out.println(joinPoint.getSignature().getName()+"方法异常为"+targetMethodException);

    }

    @After(value = "cn.wangye.pointcut.MyPointcut.SecondPointCut()")//这里直接就相当于引用了，而不是在字符串里面写东西
    public void printLogFinallyEnd() {
        System.out.println("[AOP后置通知] 方法最终结束了");
    }

}