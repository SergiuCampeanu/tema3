package com.company;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sncam
 */
public class CursuriInMemoryRepo implements CrudRepository<Course>{
    private List<Course> courses = new ArrayList<Course>();

    /**
     * @param id -the id of the entity to be returned id must not be null
     * @return the entity with the specified id or null if there is no entity with the given id
     * @throws Exception if the id is null or student list is empty
     */
    @Override
    public Course findOne(Long id) throws Exception {

        if (courses.isEmpty())
        {
            throw new Exception("Course list is empty");
        }
        if(id==null)
        {
            throw new Exception("Id can't be null");
        }
        else
        {
            for (Course c : courses) {
                if (id == c.getCourseId()) {
                    return c;
                }
            }
        }
        return null;
    }

    /**
     * @return all entities
     */
    @Override
    public Iterable<Course> findAll() {

        return courses;
    }

    /**
     * @param entity entity must be not null
     * @return null if the given entity is saved, otherwise returns the entity (id already exists)
     */
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

    /**
     * @param entity entity must be not null
     * @return the removed entity or null if there is no entity with the given id
     * @throws Exception if course list is empty
     */
    @Override
    public Course delete(Course entity) throws Exception {

        if(courses.isEmpty())
        {
            throw new Exception("Course list is empty");
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

    /**
     * @param entity entity must not be null
     * @return null if the entity is updated, otherwise returns the entity
     */
    @Override
    public Course update(Course entity) {

        for(Course course: courses) {
            if (course.getCourseId() == entity.getCourseId()) {
                course.setName(entity.getName());
                course.setTeacher(entity.getTeacher());
                course.setMaxEnrolled(entity.getMaxEnrolled());
                course.setStudentsEnrolled(entity.getStudentsEnrolled());
                course.setCredits(entity.getCredits());
                return null;
            }
        }
        return entity;
    }

}
