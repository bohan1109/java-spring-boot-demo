package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentClass {
    @PostMapping("/students")
    public String Create(@RequestBody Student student){
        System.out.println("student Name："+student.getName());
        System.out.println("student id："+student.getId());
        return "Create";
    }

    @GetMapping("/students/{id}")
    public String Get(@PathVariable Integer id){
        System.out.println("id"+id);
        return "Get";
    }
    @PutMapping("/students/{id}")
    public String put(@PathVariable Integer id,
            @RequestBody Student student){
        System.out.println("id:"+id);
        System.out.println("student Name："+student.getName());
        return "Put";
    }
    @DeleteMapping("/students/{id}")
    public String Delete(@PathVariable Integer id){
        System.out.println("id:"+id);
        return "Delete";
    }
}
