package com.example.demo;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/test1")
    public String test1 (@RequestParam Integer id,
                         @RequestParam(name = "name",required = false,defaultValue = "10") String name){
        System.out.println("id:"+id);
        System.out.println("name:"+name);
        return "test1";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student){
        System.out.println("studentId:"+student.getId() );
        System.out.println("studentName:"+student.getName() );
        return "test2";
    }

}
