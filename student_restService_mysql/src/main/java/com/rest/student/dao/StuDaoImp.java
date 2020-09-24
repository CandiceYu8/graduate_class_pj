package com.rest.student.dao;

import com.rest.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StuDaoImp implements StuDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> findAll() {
        String sql = "SELECT * FROM test";
        RowMapper<Student> rowMapper=new BeanPropertyRowMapper<Student>(Student.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public Student findById(long studentId) {
        String sql = "SELECT * FROM test WHERE studentId=?";
        RowMapper<Student> rowMapper=new BeanPropertyRowMapper<Student>(Student.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, studentId);
    }

    public void insertStudent(Student student) {
        String sql = "INSERT INTO test VALUE(?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getStudentId(), student.getName(),
                                student.getDepartment(), student.getMajor());
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE test SET name=?, department=?, major=? WHERE studentId=?";
        jdbcTemplate.update(sql, student.getName(), student.getDepartment(),
                                student.getMajor(), student.getStudentId());
    }

    public void deleteStudent(long studentId) {
        String sql = "DELETE FROM test WHERE studentId=?";
        jdbcTemplate.update(sql, studentId);
    }
}
