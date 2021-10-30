package com.company.controller;

import com.company.domain.Course;
import com.company.domain.Student;
import com.company.repository.StudentInMemoryRepo;

public class StudentController {
    private StudentInMemoryRepo repository;

    public StudentController(StudentInMemoryRepo studentRepo){
        this.repository = studentRepo;
    }

    public Student findStudentById(Long studentId){
        return this.repository.findOne(studentId);
    }

    public Boolean addCourseToStudent(Long studentId, Course course) {
        Student updatedStudent = this.repository.addCourseToStudent(studentId,course);
        return updatedStudent!=null;
    }

    public Student updateStudent(Student student) {
        return this.repository.update(student);
    }
}
