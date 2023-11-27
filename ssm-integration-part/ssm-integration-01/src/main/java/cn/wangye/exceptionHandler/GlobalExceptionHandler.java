package cn.wangye.exceptionHandler;


import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object handlerJsonDateException(HttpMessageNotReadableException e){
        return "ok-HttpMessageNotReadableException-ok";
    }



    @ExceptionHandler(Exception.class)
    public String handlerException(Exception e){
        return "exception所有错误的父亲";
    }

}
