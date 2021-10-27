package com.company;

import java.util.ArrayList;
import java.util.List;

public class CursuriInMemoryRepo implements CrudRepository<Cursuri>{
    private List<Cursuri> curs = new ArrayList<Cursuri>();

    @Override
    public Cursuri findOne(Long id) throws Exception {

        if (curs.isEmpty())
        {
            throw new Exception("student is empty");
        }
        if(id==null)
        {
            throw new Exception("id can't be null");
        }
        else
        {
            for (Cursuri c : curs) {
                if (id == c.getIdCurs()) {
                    return c;
                }
            }
        }
        return null;
    }

    @Override
    public Iterable<Cursuri> findAll() {

        return null;
    }

    @Override
    public Cursuri save(Cursuri entity) {
        for(Cursuri c:curs)
        {
            if(c.equals(entity))
            {
                return c;
            }
        }
        curs.add(entity);
        return null;

    }

    @Override
    public Cursuri delete(Cursuri entity) throws Exception {

        if(curs.isEmpty())
        {
            throw new Exception("student is empty");
        }
        else
        {
            for (Cursuri c : curs) {

                if (c.equals(entity)) {
                    Cursuri copy = entity;
                    curs.remove(entity);
                    return copy;
                }
            }
        }
        return null;
    }

    @Override
    public Cursuri update(Cursuri entity) {
        return null;
    }

}
