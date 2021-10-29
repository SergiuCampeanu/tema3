package com.company.domain;
import java.util.List;
import java.util.Objects;

/**
 * @author sncam
 */
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

    /*
    getter and setter
    */

    /**
     * @return studentId
     */
    public long getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the id of the student
     */
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    /**
     * @return totalCredit
     */
    public int getTotalCredit() {
        return totalCredit;
    }

    /**
     *
     * @param totalCredit credits of the student
     */
    public void setTotalCredit(int totalCredit) {
        this.totalCredit = totalCredit;
    }

    /**
     * @return enrolledCourses
     */
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    /**
     * @param enrolledCourses courses where the student goes
     */
    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && totalCredit == student.totalCredit && Objects.equals(enrolledCourses, student.enrolledCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, totalCredit, enrolledCourses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", studentId=" + studentId +
                ", totalCredit=" + totalCredit +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }
}
