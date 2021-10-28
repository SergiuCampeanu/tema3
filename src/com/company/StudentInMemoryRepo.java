package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sncam
 */
public class StudentInMemoryRepo implements CrudRepository<Student>{
    private List<Student> student = new ArrayList<Student>();

    /**
     * @param id -the id of the entity to be returned id must not be null
     * @return the entity with the specified id or null if there is no entity with the given id
     * @throws Exception if the id is null or student list is empty
     */
    @Override
    public Student findOne(Long id) throws Exception {
        if (student.isEmpty())
        {
            throw new Exception("Student list is empty");
        }
        if(id==null)
        {
            throw new Exception("Id can't be null");
        }
        else
        {
            for (Student s : student) {
                if (id == s.getStudentId()) {
                    return s;
                }
            }
        }
    return null;
    }

    /**
     * @return all entities
     */
    @Override
    public Iterable<Student> findAll() {

        return student;
    }

    /**
     * @param entity entity must be not null
     * @return null if the given entity is saved, otherwise returns the entity (id already exists)
     */
    @Override
    public Student save(Student entity) {
        for(Student s:student)
        {
            if(s.equals(entity))
            {
                return s;
            }
        }
        student.add(entity);
        return null;
    }

    /**
     * @param entity entity must be not null
     * @return the removed entity or null if there is no entity with the given id
     * @throws Exception if student list is empty
     */
    @Override
    public Student delete(Student entity) throws Exception {
        if(student.isEmpty())
        {
            throw new Exception("Student list is empty");
        }
        else
        {
            for (Student s : student) {

                if (s.equals(entity)) {
                    student.remove(entity);
                    return entity;
                }
            }
        }
        return null;
    }

    /**
     * @param entity entity must not be null
     * @return null if the entity is updated, otherwise returns the entity
     */
    @Override
    public Student update(Student entity) {

        for(Student student: student) {
            if (student.getStudentId() == entity.getStudentId()) {
                student.setName(entity.getName());
                student.setFirstName(entity.getFirstName());
                student.setTotalCredit(entity.getTotalCredit());
                student.setEnrolledCourses(entity.getEnrolledCourses());
                return null;
            }
        }
        return entity;
    }
}
