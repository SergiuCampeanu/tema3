package com.company;

import java.util.ArrayList;
import java.util.List;

public class TeacherInMemoryRepo implements CrudRepository<Teacher>{
    private List<Teacher> teacher = new ArrayList<Teacher>();

    @Override
    public Teacher findOne(Long id) throws Exception {
/*
        if (teacher.isEmpty())
        {
            throw new Exception("student is empty");
        }
        if(id==null)
        {
            throw new Exception("id can't be null");
        }
        else
        {
            for (Teacher t : teacher) {
                if (id == t.getNrProf()) {
                    return t;
                }
            }
        }*/
        return null;
    }

    @Override
    public Iterable<Teacher> findAll() {

        return null;
    }

    @Override
    public Teacher save(Teacher entity) {
        for(Teacher t:teacher)
        {
            if(t.equals(entity))
            {
                return t;
            }
        }
        teacher.add(entity);
        return null;

    }

    @Override
    public Teacher delete(Teacher entity) throws Exception {

        if(teacher.isEmpty())
        {
            throw new Exception("student is empty");
        }
        else
        {
            for (Teacher t : teacher) {

                if (t.equals(entity)) {
                    Teacher copy = entity;
                    teacher.remove(entity);
                    return copy;
                }
            }
        }
        return null;
    }

    @Override
    public Teacher update(Teacher entity) {
        return null;
    }
}

