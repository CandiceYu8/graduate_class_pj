package com.rest.student.controller;

import com.rest.student.model.Student;
import com.rest.student.service.StuService;
import com.rest.student.utils.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    public static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StuService stuService;

    // -------------------Add a Student-------------------------------------------

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@RequestBody Student stu,
                                        UriComponentsBuilder ucBuilder) {
        logger.info("Add Student : {}", stu);

        if (stuService.isStudentExist(stu)) {
            logger.error("Unable to add. A student with studentId {} already exist", stu.getStudentId());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. " +
                    "A User with id " + stu.getStudentId() + " already exist."), HttpStatus.CONFLICT);
        }
        stuService.addStudent(stu);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    // -------------------Retrieve All Students---------------------------------------------

    @GetMapping("/student")
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> students = stuService.findAllStudents();
        if (students.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // ------------------- Update a Student ------------------------------------------------

    @PutMapping("/student")
    public ResponseEntity<?> updateStudent(@RequestBody Student stu) {
        long id = stu.getStudentId();
        logger.info("Updating student with id {}", id);

        Student currentStu = stuService.findById(id);
        if (currentStu == null) {
            logger.error("Unable to update. Student with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to update. " +
                    "Student with id " + id + " not found."), HttpStatus.NOT_FOUND);
        }

        if (stu.getName() == null) {stu.setName(currentStu.getName());}
        if (stu.getDepartment() == null) {stu.setDepartment(currentStu.getDepartment());}
        if (stu.getMajor() == null) {stu.setMajor(currentStu.getMajor());}
        stuService.updateStudent(stu);
        return new ResponseEntity<>(stu, HttpStatus.OK);
    }

    // ------------------- Delete a Student-----------------------------------------

    @DeleteMapping("/student")
    public ResponseEntity<?> deleteStudent(@RequestBody Student stu) {
        long id = stu.getStudentId();
        logger.info("Deleting student with id {}", id);

        Student findStu = stuService.findById(id);
        if (findStu == null) {
            logger.error("Unable to delete. Student with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. " +
                    "Student with id " + id + " not found."), HttpStatus.NOT_FOUND);
        }
        stuService.deleteStudentById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
