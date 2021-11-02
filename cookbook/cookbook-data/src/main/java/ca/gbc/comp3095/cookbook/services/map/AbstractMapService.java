package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<O extends BaseEntity, ID extends Long>{

    protected Map<Long, O> map = new HashMap<>();

    Set<O> findAll() {
        return new HashSet(map.values());
    }

    O findById(ID id){
        return map.get(id);
    }

    O save(O object){
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    private Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(O object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }
}
