package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    //會先運行下面的before方法，在運行@Before註解內的方法
    @Before("execution(* com.example.demo.HpPrinter.*(..))")
    public void before() {
        System.out.println("Before Method");
    }

    //會先運行上面@After註解內的方法，在運行下面after方法
    @After("execution(* com.example.demo.HpPrinter.*(..))")
    public void after() {
        System.out.println("After Method");
    }
}
