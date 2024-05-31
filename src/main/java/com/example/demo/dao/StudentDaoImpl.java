package com.example.demo.dao;

import com.example.demo.model.Student;
import com.example.demo.mapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Student getStudentById(Integer studentId) {
        String sql = "select id,name from student where id = :studentId";
        Map<String,Object> map = new HashMap<>();
        map.put("studentId", studentId);
        List<Student> list = namedParameterJdbcTemplate.query(sql, map,new StudentRowMapper());
        if(list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Integer createStudent(Student student) {
        String sql = "INSERT INTO student(name) VALUES (:studentName)";
        Map<String, Object> map = new HashMap<>();
        map.put("studentName", student.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
        int id = keyHolder.getKey().intValue();
        System.out.println("自動生成的id為："+id);
        return id;
    }

    @Override
    public int[] createBatchStudent(List<Student> studentList) {
        String sql = "INSERT INTO student(name) VALUES (:name)";
        MapSqlParameterSource[] parameterSource = new MapSqlParameterSource[studentList.size()];
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            parameterSource[i] = new MapSqlParameterSource();
            parameterSource[i].addValue("name", student.getName());
        }
        return namedParameterJdbcTemplate.batchUpdate(sql,parameterSource);
    }

    @Override
    public Integer updateStudent(Student student) {
        String sql = "update student set name=:studentName where id=:studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());
        return namedParameterJdbcTemplate.update(sql,map);
    }

    @Override
    public Integer deleteStudent(Integer studentId) {
        String sql = "DELETE FROM student WHERE id = :studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        return namedParameterJdbcTemplate.update(sql,map);
    }
}
