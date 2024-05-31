package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public Integer createStudent(Student student) {
        return studentDao.createStudent(student);
    }

    @Override
    public Integer createBatchStudent(List<Student> studentList) {
        int[] results = studentDao.createBatchStudent(studentList);
        int totalAffectedRows = 0;
        for (int rows : results) {
            totalAffectedRows += rows;
        }
        return totalAffectedRows;
    }

    @Override
    public Integer updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Integer deleteStudent(int studentId) {
        return studentDao.deleteStudent(studentId);
    }
}
