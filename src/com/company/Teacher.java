package com.company;

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

    public void addCurs(Course c) {
        courses.add(c);
    }

    public void delCurs(Course c) {
        courses.remove(c);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(courses, teacher.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courses);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", courses=" + courses +
                '}';
    }
}