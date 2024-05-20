package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspect {

    @Around("execution(* com.example.demo.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint jpj) throws Throwable {
        Date start = new Date();
        //執行切入點的方法
        Object obj = jpj.proceed();
        Date end = new Date();
        long time = end.getTime() - start.getTime();
        System.out.println("總共運行了："+time+"ms");
        return obj;
    }
}
