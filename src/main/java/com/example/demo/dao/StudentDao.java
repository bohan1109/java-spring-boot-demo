package com.example.demo.dao;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentDao {
    Student getStudentById(Integer id);
    Integer createStudent(Student student);
    int[] createBatchStudent(List<Student> studentList);
    Integer updateStudent(Student student);
    Integer deleteStudent(Integer id);
}
