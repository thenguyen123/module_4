package com.example.book.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    static int count=0;
    static int count1=0;
    @Pointcut("within(com.example.book.controller.BookController)")
    public void getShow(){

    }
    @After(value ="getShow()" )
    public void printCount(){
        count ++;
        System.out.println("Số lần truy cập " +count);
    }
    @Pointcut("execution(* com.example.book.controller.BookController.update(..))|| execution(* com.example.book.controller.BookController.bookReturn(..))")
    public void showCount(){}
    @After(value = "showCount()")
    public void printChange(){
        count1 ++;
        System.out.println("số lần thay đổi là " + count1);
    }
}
