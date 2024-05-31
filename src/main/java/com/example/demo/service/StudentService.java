package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(int id);
    Integer createStudent(Student student);
    Integer createBatchStudent(List<Student> studentList);
    Integer updateStudent(Student student);
    Integer deleteStudent(int id);
}
