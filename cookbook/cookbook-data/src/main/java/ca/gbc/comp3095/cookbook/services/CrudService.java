package ca.gbc.comp3095.cookbook.services;

import java.util.Set;

public interface CrudService<O, ID>{

    Set<O> findAll();
    O findById(ID id);
    O save(O Object);
    void delete(O object);
    void deleteById(ID id);
}
