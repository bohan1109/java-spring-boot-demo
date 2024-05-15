package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class APrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println("A印表機："+message);
    }
}
