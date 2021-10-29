package com.company.view;

import com.company.controller.MainController;
import com.company.domain.Course;

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
        builder.append("1.Add student to course\n")
                .append("2.Get all courses\n");
        System.out.println(builder.toString());
    }

    private void startConsole(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String opt = scanner.nextLine();
            switch (opt){
                case "1":
                    System.out.println("Please insert course id");
                    String courseId = scanner.nextLine();
                    System.out.println("Please insert studentId");
                    String studentId = scanner.nextLine();
                    try {
                        boolean response = this.mainController.registerStudentToCourse(Long.getLong(courseId), Long.getLong(studentId));
                        if(response) System.out.println("Student added successfully");
                        else System.out.println("Failed to add student to course");
                    }catch (Exception e){
                        System.out.println("Exception occurred:");
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    Iterable<Course> courseList = this.mainController.getAllCourses();
                    for(Course course:courseList){
                        System.out.println(course.getName()+" , available places = "+String.valueOf(course.getStudentsEnrolled().size()-course.getMaxEnrolled()));
                    }
                    break;
            }
        }
    }

}
