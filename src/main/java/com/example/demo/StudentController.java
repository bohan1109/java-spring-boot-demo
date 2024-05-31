package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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


    @PostMapping("/students")
    public String insert(@RequestBody Student student){
        String sql = "INSERT INTO student(name) VALUES (:studentName)";
        Map<String, Object> map = new HashMap<>();
        map.put("studentName", student.getName());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql,new MapSqlParameterSource(map),keyHolder);
        int id = keyHolder.getKey().intValue();
        System.out.println("自動生成的id為："+id);
        return "insert success";
    }

    @PostMapping("/students/batch")
    public String insertList(@RequestBody List<Student> studentList){
        String sql = "INSERT INTO student(name) VALUES (:name)";
        MapSqlParameterSource[] parameterSource = new MapSqlParameterSource[studentList.size()];
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            parameterSource[i] = new MapSqlParameterSource();
            parameterSource[i].addValue("name", student.getName());
        }
        namedParameterJdbcTemplate.batchUpdate(sql,parameterSource);
        return "insert studentList success";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable("studentId") int studentId,
                         @RequestBody Student student){
        String sql = "update student set name=:studentName where id=:studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        map.put("studentName", student.getName());
        namedParameterJdbcTemplate.update(sql,map);
        return "update success";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable int studentId){
        String sql = "DELETE FROM student WHERE id = :studentId";
        Map<String, Object> map = new HashMap<>();
        map.put("studentId", studentId);
        namedParameterJdbcTemplate.update(sql,map);
        return "delete success";
    }

    @GetMapping("/students/{studentId}")
    public Student select(@PathVariable int studentId){
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
}
