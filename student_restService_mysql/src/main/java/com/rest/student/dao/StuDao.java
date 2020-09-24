package com.rest.student.dao;

import com.rest.student.model.Student;

import java.util.List;

public interface StuDao {

    List<Student> findAll();

    Student findById(long studentId);

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(long studentId);
}
