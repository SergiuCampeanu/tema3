package com.company.view;

import com.company.controller.MainController;
import com.company.domain.Course;
import com.company.domain.Student;

import java.util.Scanner;

public class RegistrationSystem {

    private MainController mainController;

    public RegistrationSystem(MainController mainController) {
        this.mainController = mainController;
    }

    public void startApplication(){
        this.showMenu();
        this.startConsole();
    }

    private void showMenu(){
        StringBuilder builder = new StringBuilder();
        builder.append("Welcome to the University's Application")
                .append("Press: 1 for add student to course\n")
                .append("Press: 2 for get all courses\n")
                .append("Press: 3 for get all student of a course\n")
                .append("Press: 4 for get all course with free places\n")
                .append("Press: 5 for a teacher to delete a course in his list\n")
                .append("Press: 0 to exit application\n")
                .append("Your choise: ");
        System.out.println(builder.toString());
    }

    private void startConsole(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String opt = scanner.nextLine();
            switch (opt) {

                case "1":
                    System.out.println("Please insert course id");
                    String courseId = scanner.nextLine();
                    System.out.println("Please insert student id");
                    String studentId = scanner.nextLine();

                    try {
                        boolean response = this.mainController.registerStudentToCourse(Long.getLong(courseId), Long.getLong(studentId));
                        if (response) System.out.println("Student added successfully");
                        else System.out.println("Failed to add student to course");
                    } catch (Exception e) {
                        System.out.println("Exception occurred:");
                        System.out.println(e.getMessage());
                    }
                    break;

                case "2":
                    Iterable<Course> courseList = this.mainController.getAllCourses();
                    for (Course course : courseList) {
                        System.out.println(course.getName() + " , available places = " + String.valueOf(course.getStudentsEnrolled().size() - course.getMaxEnrolled()) + "\n");
                    }
                    break;

                case "3":
                    System.out.println("Please insert course id");
                    courseId = scanner.nextLine();

                    try {
                        Iterable<Student> studentListInACourse = this.mainController.getAllStudentsByCourseId(Long.getLong(courseId));
                        for (Student student : studentListInACourse) {
                            System.out.println("Id of the student in this course: " + student.getStudentId() + "\n");
                        }
                    } catch (Exception e) {
                        System.out.println("Exception occurred:");
                        System.out.println(e.getMessage());
                    }
                    break;

                case "4":
                    Iterable<Course> availableCourseList = this.mainController.getAllAvailableCourses();
                    for (Course course : availableCourseList) {
                        System.out.println("all the available courses: " + availableCourseList + "\n");
                    }
                    break;

                case "5":
                    System.out.println("Please insert course id");
                    courseId = scanner.nextLine();
                    System.out.println("Please insert teacher id");
                    String teacherId = scanner.nextLine();

                    try {
                        boolean response = this.mainController.deleteCourseFromTeacher(Long.getLong(courseId), Long.getLong(teacherId));
                        if (response) System.out.println("Course deleted successfully");
                        else System.out.println("Failed to delete course");
                    } catch (Exception e) {
                        System.out.println("Exception occurred:");
                        System.out.println(e.getMessage());
                    }
                    break;

                case "0":
                    System.out.println("Good-Bye!!");
                    return;
            }
        }
    }

}
