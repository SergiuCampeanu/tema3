package com.company;

import java.util.ArrayList;
import java.util.List;

public class CursuriInMemoryRepo implements CrudRepository<Cursuri>{
    private List<Cursuri> curs = new ArrayList<Cursuri>();

    @Override
    public Cursuri findOne(Long id) {

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
    public Cursuri delete(Cursuri entity) {

        return null;
    }

    @Override
    public Cursuri update(Cursuri entity) {
        return null;
    }

}
