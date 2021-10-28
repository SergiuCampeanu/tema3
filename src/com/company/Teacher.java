package com.company;

import java.util.List;

public class Teacher extends Person {

    private List<Course> courses;

    public Teacher(String name, String firstName, List<Course> courses) {
        super(name, firstName);
        this.courses = courses;
    }

    public void addCurs(Course c) {
        courses.add(c);
    }

    public void delCurs(Course c) {
        courses.remove(c);
    }

}