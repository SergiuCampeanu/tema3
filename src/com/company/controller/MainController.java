package com.company.controller;
import com.company.domain.Course;
import com.company.domain.Student;
import com.company.domain.Teacher;

import java.util.List;

public class MainController {
    private CourseController courseController;
    private StudentController studentController;
    private TeacherController teacherController;


    public MainController(CourseController courseController, StudentController studentController, TeacherController teacherController) {
        this.courseController = courseController;
        this.studentController = studentController;
        this.teacherController = teacherController;
    }

    public boolean registerStudentToCourse(Long studentId, Long courseId){
        Student student = this.studentController.findStudentById(studentId);
        Course course = this.courseController.findCourseById(courseId);

        if(course.getStudentsEnrolled().size() == course.getMaxEnrolled())
            throw new RuntimeException("Course is full");
        if(student.getTotalCredit()+course.getCredits() > 30)
            throw new RuntimeException("To many Credits");

        Boolean courseAddedToStudent = this.studentController.addCourseToStudent(studentId,course);
        Boolean studentAddedToCourse = this.courseController.addStudentToCourse(courseId,student);

        return courseAddedToStudent|studentAddedToCourse;
    }

    public Iterable<Course> getAllCourses(){
        return this.courseController.getAllCourses();
    }

    public Iterable<Student> getAllStudentsByCourseId(Long courseId){
        return this.courseController.getCourseById(courseId).getStudentsEnrolled();
    }

    public Iterable<Course> getAllAvailableCourses(){
        return this.courseController.getAvailableCourses();
    }

    public boolean updateCourse(String courseName, long teacherId, int maxEnrolled, long courseId, int credits){
        Course existingCourse = this.courseController.findCourseById(courseId);
        Course course = new Course(courseName, this.teacherController.findById(teacherId), maxEnrolled, courseId, null ,credits);
        if(existingCourse.getCredits() != credits)
        {
            for(Student student: existingCourse.getStudentsEnrolled()){
                Student newStudent = new Student(student.getName(),student.getFirstName(),student.getStudentId(),student.getTotalCredit(),student.getEnrolledCourses());
                newStudent.getEnrolledCourses().removeIf(course1->course1.getCourseId()==courseId);
                newStudent.getEnrolledCourses().add(course);
                this.studentController.updateStudent(newStudent);
            }
        }
        return this.courseController.updateCourse(course) != null;
    }

    public boolean deleteCourseFromTeacher(long courseId, long teacherId){
        Teacher existingTeacher = this.teacherController.findById(teacherId);
        List<Course> newCourseList = existingTeacher.getCourses();
        newCourseList.removeIf(course1->course1.getCourseId()==courseId);

        Teacher newTeacher= new Teacher(existingTeacher.getName(), );
        Course course = this.courseController.getCourseById(courseId);
        for(Student student: course.getStudentsEnrolled()){
            Student newStudent = new Student(student.getName(),student.getFirstName(),student.getStudentId(),student.getTotalCredit(),student.getEnrolledCourses());
            newStudent.getEnrolledCourses().removeIf(course1 -> course1.getCourseId()==courseId);
            this.studentController.updateStudent(newStudent);
        }


        return this.teacherController.updateTeacher(newTeacher)!= null;
    }

}
