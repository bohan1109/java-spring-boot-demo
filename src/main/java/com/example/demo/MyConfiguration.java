package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Configuration 的 Class 名稱(MyConfiguration)不影響使用，可以隨意替換
@Configuration
public class MyConfiguration {

    //@Bean後面沒有加上("")指定名稱的話，會直接用方法名稱(myPrinter)命名
    @Bean
    public Printer myPrinter(){
        return new HpPrinter();
    }

    @Bean
    public Printer yourPrinter(){
        return new BrotherPrinter();
    }
}
