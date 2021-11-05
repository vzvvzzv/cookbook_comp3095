package ca.gbc.comp3095.cookbook.services.map;

import org.springframework.data.repository.CrudRepository;

import java.util.*;

public abstract class AbstractMapService<T, ID extends Long>{

    protected Map<Long, T> map = new HashMap<>();

    /*
    Set<T> findAll() {
        return new HashSet(map.values());
    }
    */

    Set<T> findAll(CrudRepository repo) {
        return new HashSet((Collection) repo.findAll());
    }

    /*
    T findById(ID id){
        return map.get(id);
    }
    */

    T findById(CrudRepository repo, ID id) {
        try {
            return (T) repo.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    T save(CrudRepository repo, T object) {
        repo.save(object);
        return object;
    }

    /*
    T save(ID id, T object){
        map.put(id, object);
        return object;
    }
     */

    /*
    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
    */

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
