package com.company;
import java.util.List;

public class Student extends Person {

    public long studentId;
    public int totalCredit;
    public List<Course> enrolledCourses;

    public Student(String name, String firstName, long studentId, int totalCredit, List<Course> enrolledCourses) {
        super(name, firstName);
        this.studentId = studentId;
        this.totalCredit = totalCredit;
        this.enrolledCourses = enrolledCourses;
    }

    public void addCurs(Course c) throws Exception {
        if(totalCredit+c.getCredits()>30)
        {
            throw new Exception("Prea multe credite");
        }
        if(c.getStudentsEnrolled().size()+1 > c.getMaxEnrolled())
        {
            throw new Exception("Nu mai sunt locuri disponibile la acest curs");
        }
        else
        {
            enrolledCourses.add(c);
            totalCredit += c.getCredits();
        }
    }

    public void delCurs(Course c){
        enrolledCourses.remove(c);
        totalCredit-=c.getCredits();
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public int getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(int totalCredit) {
        this.totalCredit = totalCredit;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
