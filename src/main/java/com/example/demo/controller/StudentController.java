package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public String insert(@RequestBody Student student){
        int id = studentService.createStudent(student);
        if(id > 0){
            return "insert success";
        }else {
            return "insert failed";
        }

    }

    @PostMapping("/students/batch")
    public String insertList(@RequestBody List<Student> studentList){
        int count = studentService.createBatchStudent(studentList);
        if(count > 0){
            return "insert studentList success";
        }else {
            return "insert studentList failed";
        }

    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable("studentId") int studentId,
                         @RequestBody Student student){
        student.setId(studentId);
        int id = studentService.updateStudent(student);

        if(id > 0){
            return "update success";
        }else {
            return "update failed";
        }
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable int studentId){
        int id = studentService.deleteStudent(studentId);
        if(id > 0){
            return "delete success";
        }else {
            return "delete failed";
        }
    }

    @GetMapping("/students/{studentId}")
    public Student select(@PathVariable int studentId){
        return studentService.getStudentById(studentId);

    }
}
