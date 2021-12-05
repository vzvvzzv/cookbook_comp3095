/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
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
