package com.rest.student.service;

import com.rest.student.dao.StuDao;
import com.rest.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StuServiceImp implements StuService{

    @Autowired
    private StuDao stuDao;

    public Student findById(long studentId) {
        Student result;
        try {
            result = stuDao.findById(studentId);
        } catch (DataAccessException e){
            result = null;
        }
        return result;
    }

    public void addStudent(Student student) {
        stuDao.insertStudent(student);
    }

    public void updateStudent(Student student){
        stuDao.updateStudent(student);
    }

    public void deleteStudentById(long studentId) {
        stuDao.deleteStudent(studentId);
    }

    public List<Student> findAllStudents(){
        return stuDao.findAll();
    }

    public boolean isStudentExist(Student student){
        return findById(student.getStudentId()) != null;
    }

}
