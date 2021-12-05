/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: ShoppingListService.java is an interface which extends the CrudService
 * and works with ShoppingLists & Long objects. Establishes extra crud operation methods specifically for ShoppingLists
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services;

import ca.gbc.comp3095.cookbook.model.ShoppingList;

import java.util.Set;

public interface ShoppingListService extends CrudService<ShoppingList, Long> {

    // Methods to be expanded upon
    // Get ShoppingLists by User Id
    Set<ShoppingList> findAllByUserId(Long id);
}
