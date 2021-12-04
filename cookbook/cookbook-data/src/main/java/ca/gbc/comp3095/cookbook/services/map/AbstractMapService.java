/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment1
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan
 * Student Number: 101203877, 101032525, 101269485
 * Date: 2021-11-06
 * Description: AbstractMapService.java is an abstract class for other ServiceMaps to extend upon. AbstractMapService
 * establishes basic operations with generic types for all extended services
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services.map;

import org.springframework.data.repository.CrudRepository;

import java.util.*;

public abstract class AbstractMapService<T, ID extends Long>{

    // For use with delete methods (Possible change later)
    protected Map<Long, T> map = new HashMap<>();

    // Implemented methods & possibly expanded upon later
    // find all objects from the repository & returns hashset of the objects
    Set<T> findAll(CrudRepository repo) {
        return new HashSet((Collection) repo.findAll());
    }

    // finds an object from the repository by id and returns that object
    T findById(CrudRepository repo, ID id) {
        try {
            return (T) repo.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    // saves an object into the repository
    T save(CrudRepository repo, T object) {
        repo.save(object);
        return object;
    }

    // Possibly change delete methods later
    void deleteById(CrudRepository repo, ID id){
        try {
            repo.deleteById(id);
        } catch (Exception e) {

        }
    }

    void delete(CrudRepository repo, T object){
        try {
            repo.delete(object);
        } catch (Exception e) {

        }
    }
}
