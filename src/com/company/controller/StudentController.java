package com.company.controller;

import com.company.domain.Course;
import com.company.domain.Student;
import com.company.repository.StudentInMemoryRepo;

public class StudentController {
    private StudentInMemoryRepo studentRepo;

    public StudentController(StudentInMemoryRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    public Student findStudentById(Long studentId){
        return this.studentRepo.findOne(studentId);
    }

    public Boolean addCourseToStudent(Long studentId, Course course) {
        Student updatedStudent = this.studentRepo.addCourseToStudent(studentId,course);
        return updatedStudent!=null;
    }

    public boolean updateStudent(Student newStudent) {
    }
}
