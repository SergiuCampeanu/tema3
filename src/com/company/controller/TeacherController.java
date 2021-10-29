package com.company.controller;

import com.company.domain.Teacher;
import com.company.repository.TeacherInMemoryRepo;

public class TeacherController {
    private TeacherInMemoryRepo teacherRepo;

    public TeacherController(TeacherInMemoryRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public Teacher findById(long teacherId){
        return this.teacherRepo.findOne(teacherId);
    }

    public Teacher updateTeacher(Teacher newTeacher) {
        return this.teacherRepo.update(newTeacher);
    }
}
