package com.dream.order.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author huzejun
 * @Date 2025-09-12 12:37
 **/

//@ResponseBody
//@ControllerAdvice

@RestControllerAdvice   //全局异常处理器
public class GlobalExceptionHandler {

//    @ExceptionHandler(Throwable.class)
//    public String error(Throwable e) {
//        return "";
//    }

}
