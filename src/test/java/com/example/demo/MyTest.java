package com.example.demo;

import org.junit.jupiter.api.*;

public class MyTest {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("Before All");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After All");
    }

    @Disabled
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @DisplayName("Test3方法")
    @Test
    public void test2(){
        System.out.println("test2");
    }
}
