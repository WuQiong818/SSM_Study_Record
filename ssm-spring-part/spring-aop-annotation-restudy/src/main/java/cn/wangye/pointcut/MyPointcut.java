package cn.wangye.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointcut {
    @Pointcut(value = "execution(public int cn.wangye.service.impl.CalculatorPureImpl.add(int,int))")
    public void SecondPointCut(){}

//    @Pointcut(value = "execution(* *..*(..))")
    public void GlobalPointCut(){}

}
