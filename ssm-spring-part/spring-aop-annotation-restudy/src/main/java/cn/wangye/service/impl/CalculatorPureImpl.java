package cn.wangye.service.impl;


import cn.wangye.service.Calculator;
import org.springframework.stereotype.Component;

/**
 * 实现计算接口,单纯添加 + - * / 实现! 掺杂其他功能!
 */
@Component
public class CalculatorPureImpl implements Calculator {
    @Override
    public int addition(String i, int j) {
        String result = i + j;
        System.out.println("这是方法中的东西");
        return 1/0;
    }
    
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("这是方法中的东西");
        return 1/0;
    }
    
    @Override
    public int sub(int i, int j) {
    
        int result = i - j;

        return result;
    }
    
    @Override
    public int mul(int i, int j) {
    
        int result = i * j;
    
        return result;
    }
    
    @Override
    public int div(int i, int j) {
    
        int result = i / j;
    
        return result;
    }
}