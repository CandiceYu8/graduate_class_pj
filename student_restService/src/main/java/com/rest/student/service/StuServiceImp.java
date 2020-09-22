package com.rest.student.service;

import com.rest.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("studentService")
public class StuServiceImp implements StuService{

    private static List<Student> students;

    static{
        students= populateDummyStudents();
    }

    public Student findById(long studentId) {
        for(Student stu : students) {
            if(stu.getStudentId() == studentId)
                return stu;
        }
        return null;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(Student student){
        int index = students.indexOf(student);
        students.set(index, student);
    }

    public void deleteStudentById(long studentId) {
//        for (Iterator<Student> iterator = students.iterator(); iterator.hasNext(); ) {
//            Student stu = iterator.next();
//            if (stu.getStudentId() == studentId) {
//                iterator.remove();
//            }
//        }
        students.removeIf(stu -> stu.getStudentId() == studentId);
    }

    public List<Student> findAllStudents(){
        return students;
    }

    public boolean isStudentExist(Student student){
        return findById(student.getStudentId()) != null;
    }

    private static List<Student> populateDummyStudents(){
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(202101,"Alice","A", "English"));
        students.add(new Student(202102,"Bob","B", "Arts"));
        students.add(new Student(202103,"Cathy","A", "English"));
        students.add(new Student(202104,"Elle","C", "Computer"));
        return students;
    }
}
