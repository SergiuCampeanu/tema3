package com.company;

import java.util.ArrayList;
import java.util.List;

public class StudentInMemoryRepo implements CrudRepository<Student>{
    private List<Student> student = new ArrayList<Student>();

    @Override
    public Student findOne(Long id) {

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
    public Student delete(Long id) {

        return null;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }
}
