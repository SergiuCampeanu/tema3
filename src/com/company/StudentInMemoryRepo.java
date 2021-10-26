package com.company;

import java.util.ArrayList;
import java.util.List;

public class StudentInMemoryRepo implements CrudRepository<Student>{
    private List<Student> student = new ArrayList<Student>();

    @Override
    public Student findOne(Long id) throws Exception
    {
        if (student.isEmpty())
        {
            throw new Exception("student is empty");
        }
        if(id==null)
        {
            throw new Exception("id can't be null");
        }
        else
        {
            for (Student s : student) {
                if (id == s.getNrMatricol()) {
                    return s;
                }
            }
        }
    return null;
    }

    @Override
    public Iterable<Student> findAll() {

        return null;
    }

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

    @Override
    public Student delete(Student entity) throws Exception {
        if(student.isEmpty())
        {
            throw new Exception("student is empty");
        }
        else
        {
            for (Student s : student) {

                if (s.equals(entity)) {
                    Student copy = entity;
                    student.remove(entity);
                    return copy;
                }
            }
        }
        return null;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }
}
