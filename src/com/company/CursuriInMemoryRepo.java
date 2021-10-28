package com.company;

import java.util.ArrayList;
import java.util.List;

public class CursuriInMemoryRepo implements CrudRepository<Course>{
    private List<Course> courses = new ArrayList<Course>();

    @Override
    public Course findOne(Long id) throws Exception {

       /* if (curs.isEmpty())
        {
            throw new Exception("student is empty");
        }
        if(id==null)
        {
            throw new Exception("id can't be null");
        }
        else
        {
            for (Course c : curs) {
                if (id == c.getIdCurs()) {
                    return c;
                }
            }
        }*/
        return null;
    }

    @Override
    public Iterable<Course> findAll() {

        return null;
    }

    @Override
    public Course save(Course entity) {
        for(Course c:courses)
        {
            if(c.equals(entity))
            {
                return c;
            }
        }
        courses.add(entity);
        return null;

    }

    @Override
    public Course delete(Course entity) throws Exception {

        if(courses.isEmpty())
        {
            throw new Exception("student is empty");
        }
        else
        {
            for (Course c : courses) {

                if (c.equals(entity)) {
                    Course copy = entity;
                    courses.remove(entity);
                    return copy;
                }
            }
        }
        return null;
    }

    @Override
    public Course update(Course entity) {
        return null;
    }

}
