package com.atguigu.system.exception;

import com.atguigu.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result globalError(Exception e){
        System.out.println("==================全局异常处理===================");
        e.printStackTrace();
        return Result.fail().message("执行了全局异常处理");

    }

    /**
     * 特定异常
     */
    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public Result arithmeticError(ArithmeticException e){
        System.out.println("==================特定异常处理===================");
        e.printStackTrace();
        return Result.fail().message("执行了特定异常处理");

    }


    /**
     * 自定义异常
     */
    @ResponseBody
    @ExceptionHandler(SelfDefineException.class)
    public Result selfDefineError(SelfDefineException e){
        System.out.println("=================自定义异常处理===================");
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }
}
