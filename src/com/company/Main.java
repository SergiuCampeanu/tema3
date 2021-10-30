package com.company;

public class Main {

    public static void main(String[] args) {
        CourseInMemoryRepo courseRepo = new CourseInMemoryRepo();
        TeacherInMemoryRepo teacherRepo = new TeacherInMemoryRepo();
        StudentInMemoryRepo studentRepo = new StudentInMemoryRepo();


        CourseController courseController = new CourseController(courseRepo);
        TeacherController teacherController = new TeacherController(teacherRepo);
        StudentController studentController = new StudentController(studentRepo);

        MainController mainController = new MainController(courseController, studentController, teacherController);

        RegistrationSystem registrationSystem = new RegistrationSystem(mainController);
        registrationSystem.startApplication();
    }
}
