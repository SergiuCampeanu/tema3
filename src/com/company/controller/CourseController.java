package com.company.controller;

import com.company.domain.Course;
import com.company.domain.Student;
import com.company.repository.CourseInMemoryRepo;

import java.util.ArrayList;
import java.util.List;

public class CourseController {
    private CourseInMemoryRepo repository;

    public CourseController(CourseInMemoryRepo courseInMemoryRepo){
        this.repository = courseInMemoryRepo;
    }


    public Course findCourseById(Long courseId) {
        return this.repository.findOne(courseId);
    }

    public Boolean addStudentToCourse(Long courseId, Student student) {
        Course updatedCourse = this.repository.addStudentToCourse(courseId,student);
        return updatedCourse!=null;
    }

    public Iterable<Course> getAllCourses() {
        return this.repository.findAll();
    }

    public Course getCourseById(Long courseId) {
        return this.repository.findOne(courseId);
    }

    public Iterable<Course> getAvailableCourses() {
        Iterable<Course> courseList = this.repository.findAll();
        List<Course> availableCourse = new ArrayList<>();
        for (Course c:courseList) {
            if(c.getStudentsEnrolled().size() < c.getMaxEnrolled())
            {
                availableCourse.add(c);
            }
        }
        return availableCourse;
    }

    public Course updateCourse(Course course) {
       return this.repository.update(course);
    }
}
