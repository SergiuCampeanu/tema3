package com.company;

import java.util.ArrayList;
import java.util.List;

public class ProfesorInMemoryRepo implements CrudRepository<Profesor>{
    private List<Profesor> prof = new ArrayList<Profesor>();

    @Override
    public Profesor findOne(Long id) {

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
    public Profesor delete(Profesor entity) {

        return null;
    }

    @Override
    public Profesor update(Profesor entity) {
        return null;
    }
}

