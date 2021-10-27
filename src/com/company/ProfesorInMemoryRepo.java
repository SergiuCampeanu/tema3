package com.company;

import java.util.ArrayList;
import java.util.List;

public class ProfesorInMemoryRepo implements CrudRepository<Profesor>{
    private List<Profesor> prof = new ArrayList<Profesor>();

    @Override
    public Profesor findOne(Long id) throws Exception {

        if (prof.isEmpty())
        {
            throw new Exception("student is empty");
        }
        if(id==null)
        {
            throw new Exception("id can't be null");
        }
        else
        {
            for (Profesor p : prof) {
                if (id == p.getNrProf()) {
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public Iterable<Profesor> findAll() {

        return null;
    }

    @Override
    public Profesor save(Profesor entity) {
        for(Profesor p:prof)
        {
            if(p.equals(entity))
            {
                return p;
            }
        }
        prof.add(entity);
        return null;

    }

    @Override
    public Profesor delete(Profesor entity) throws Exception {

        if(prof.isEmpty())
        {
            throw new Exception("student is empty");
        }
        else
        {
            for (Profesor p : prof) {

                if (p.equals(entity)) {
                    Profesor copy = entity;
                    prof.remove(entity);
                    return copy;
                }
            }
        }
        return null;
    }

    @Override
    public Profesor update(Profesor entity) {
        return null;
    }
}

