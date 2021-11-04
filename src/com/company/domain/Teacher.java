package com.company.domain;

import java.util.List;
import java.util.Objects;

/**
 * @author sncam
 */
public class Teacher extends Person {

    public long teacherId;
    public List<Course> courses;

    public Teacher(String name, String firstName, long teacherId, List<Course> courses) {
        super(name, firstName);
        this.teacherId = teacherId;
        this.courses = courses;
    }

    /*
    getter and setter
    */

    /**
     * @return teacher id
     */
    public long getTeacherId() {
        return teacherId;
    }

    /**
     * @param teacherId, id of the teacher
     */
    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * @return courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * @param courses courses teched by the teacher
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     *
     * @return tostring
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}