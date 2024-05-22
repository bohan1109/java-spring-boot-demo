package com.example.demo;


import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id,
                        @RequestParam(name = "name", required = false, defaultValue = "10") String name) {
        System.out.println("id:" + id);
        System.out.println("name:" + name);
        return "test1";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student) {
        System.out.println("studentId:" + student.getId());
        System.out.println("studentName:" + student.getName());
        return "test2";
    }

    @RequestMapping("/test3")
    public String test3(
            @RequestHeader(name = "Content-Type", required = false, defaultValue = "application/json") String contentType,
            @RequestHeader String info
    ) {
        System.out.println("info:" + info);
        System.out.println("Content-Type:" + contentType);
        return "test3";
    }

}
