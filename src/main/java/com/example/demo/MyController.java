package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/test1")
    public String test1() {
        System.out.println("hello test1");
        return "hello test1";
    }

    @RequestMapping("/test2")
    public String test2() {
        System.out.println("hello test2");
        return "hello test2";
    }
}
