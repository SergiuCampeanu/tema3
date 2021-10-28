package com.company;
import java.util.List;
import java.util.Objects;

/**
 * @author sncam
 */
public class Course {

    public String name;
    public Person teacher;
    public int maxEnrolled;
    public long courseId;
    public List<Student> studentsEnrolled;
    public int credits;

    public Course(String name, Person teacher, int maxEnrolled, long courseId, List<Student> studentsEnrolled, int credits) {
        this.name = name;
        this.teacher = teacher;
        this.maxEnrolled = maxEnrolled;
        this.courseId = courseId;
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

    /*
getter and setter
*/

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name of the course
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return teacher
     */
    public Person getTeacher() {
        return teacher;
    }

    /**
     * @param teacher, person who teach the course
     */
    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    /**
     * @return number max of student in the course
     */
    public int getMaxEnrolled() {
        return maxEnrolled;
    }

    /**
     * @param maxEnrolled number max of student in the course
     */
    public void setMaxEnrolled(int maxEnrolled) {
        this.maxEnrolled = maxEnrolled;
    }

    /**
     * @return course id
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * @param courseId, id of the teacher
     */
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    /**
     * @return students that are enrolled
     */
    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    /**
     * @param studentsEnrolled, list of students thate are enrolled
     */
    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    /**
     * @return credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * @param credits, vale of the course
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return maxEnrolled == course.maxEnrolled && credits == course.credits && Objects.equals(name, course.name) && Objects.equals(teacher, course.teacher) && Objects.equals(studentsEnrolled, course.studentsEnrolled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teacher, maxEnrolled, studentsEnrolled, credits);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", teacher=" + teacher +
                ", maxEnrolled=" + maxEnrolled +
                ", studentsEnrolled=" + studentsEnrolled +
                ", credits=" + credits +
                '}';
    }
}
