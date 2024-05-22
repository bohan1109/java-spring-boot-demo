package com.example.demo;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class StudentClass {
    @PostMapping("/students")
    public ResponseEntity<String> Create(@RequestBody @Valid Student student){
        System.out.println("student Name："+student.getName());
        System.out.println("student id："+student.getId());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Create");
    }

    @GetMapping("/students/{id}")
    public String Get(@PathVariable @Min(1) Integer id){
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
