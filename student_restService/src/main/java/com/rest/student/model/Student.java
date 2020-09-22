package com.rest.student.model;

public class Student {
    private long studentId;
    private String name;
    private String department;
    private String major;

    public Student(long studentId, String name, String department, String major) {
        super();
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.major = major;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "User [id=" + studentId + ", name=" + name + ", " +
                "department=" + department + ", major=" + major + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (studentId != other.studentId)
            return false;
        return true;
    }
}
