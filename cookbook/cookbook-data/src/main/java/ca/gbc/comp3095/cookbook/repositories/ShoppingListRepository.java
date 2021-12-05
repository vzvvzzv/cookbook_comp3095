/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: ShoppingListRepository.java extends the CrudRepository allows for CRUD operations to the h2-database.
 * ShoppingListRepository specifically returns ShoppingList objects and possesses special queries
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.ShoppingList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

    // Specially defined select queries using @Query
    // Returns set of shopping lists created by specific user (joined with user by userid)
    @Query("select sl from ShoppingList sl join sl.shoppingListUser u where u.id = :id")
    Set<ShoppingList> findAllByUserId(Long id);
}
