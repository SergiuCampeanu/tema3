package com.company;
import java.util.List;

public class Course {

    public String name;
    public Person teacher;
    public int maxEnrolled;
    public List<Student> studentsEnrolled;
    public int credits;

    public Course(String name, Person teacher, int maxEnrolled, List<Student> studentsEnrolled, int credits) {
        this.name = name;
        this.teacher = teacher;
        this.maxEnrolled = maxEnrolled;
        this.studentsEnrolled = studentsEnrolled;
        this.credits = credits;
    }

    public void addStudent(Student s) throws Exception {
        if(studentsEnrolled.size()==maxEnrolled)
        {
            throw new Exception("No more space in this course, please choose another one");
        }
        else {
            studentsEnrolled.add(s);
        }
    }
    public void delStudent(Student s) throws Exception {
        if(studentsEnrolled.isEmpty())
        {
            throw new Exception("No one is participating to this course");
        }
        else {
            studentsEnrolled.remove(s);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getMaxEnrolled() {
        return maxEnrolled;
    }

    public void setMaxEnrolled(int maxEnrolled) {
        this.maxEnrolled = maxEnrolled;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credite) {
        this.credits = credits;
    }
}
