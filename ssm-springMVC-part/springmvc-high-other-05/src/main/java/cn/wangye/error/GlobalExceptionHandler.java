package cn.wangye.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//直接返回字符串，这里也分字符串和视图对象，这两种
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public String arithmeticExceptionHandler(ArithmeticException e){
//        这里注册了全局处理ArithmeticException异常的机制，发生了这种异常就会在这里执行对应的步骤
        String message = e.getMessage();
        System.out.println("ArithmeticException"+message);
        return message;
    }

    @ExceptionHandler(Exception.class)
    public String ExceptionHandler(Exception e){
        String message = e.getMessage();
        System.out.println("Exception"+message);
        return message;
    }


}
