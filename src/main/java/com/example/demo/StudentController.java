package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public String insert(@RequestBody Student student){
        studentRepository.save(student);
        return "執行insert操作";
    }

    @GetMapping("/students/{studentId}")
    public Student getOneStudents(@PathVariable int studentId){
        Student student = studentRepository.findById(studentId).orElse(null);
        return student;
    }

    @PutMapping("/students/{studentId}")
    public String updateStudent(@PathVariable int studentId, @RequestBody Student student){
        Student existingStudent  = studentRepository.findById(studentId).orElse(null);
        if(existingStudent  != null){
            existingStudent .setId(studentId);
            studentRepository.save(student);
            return "執行Update操作";
        }
        else {
            return "找不到id為"+studentId+"的資料";
        }

    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId){
        studentRepository.deleteById(studentId);
        return "執行Delete操作";
    }
}
