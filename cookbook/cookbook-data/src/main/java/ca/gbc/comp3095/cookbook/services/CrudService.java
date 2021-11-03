package ca.gbc.comp3095.cookbook.services;

import java.util.Set;

public interface CrudService<T, ID>{

    Set<T> findAll();
    T findById(ID id);
    T save(T Object);
    void delete(T object);
    void deleteById(ID id);
}
