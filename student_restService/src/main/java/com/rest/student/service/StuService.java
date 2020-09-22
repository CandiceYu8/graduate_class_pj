package com.rest.student.service;

import com.rest.student.model.Student;

import java.util.List;

public interface StuService {
    Student findById(long studentId);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(long studentId);

    List<Student> findAllStudents();

    boolean isStudentExist(Student student);
}
