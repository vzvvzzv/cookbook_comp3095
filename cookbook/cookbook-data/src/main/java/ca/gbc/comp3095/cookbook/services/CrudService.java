/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment1
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan
 * Student Number: 101203877, 101032525, 101269485
 * Date: 2021-11-06
 * Description: CrudService.java is an interface to be extended from and
 * establishes basic crud operation methods for the other services
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services;

import java.util.Set;

public interface CrudService<T, ID>{

    // Methods to be implemented and expanded upon
    // Finds All and Returns the Set of that object
    Set<T> findAll();

    // Finds a specific object by Id and returns it
    T findById(ID id);

    // Saves the object to the database
    T save(T Object);

    // Delete methods
    void delete(T object);
    void deleteById(ID id);
}
