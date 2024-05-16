package com.example.demo;

import org.springframework.stereotype.Component;

//@Component
public class BrotherPrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println("Brother印表機："+message);
    }
}
