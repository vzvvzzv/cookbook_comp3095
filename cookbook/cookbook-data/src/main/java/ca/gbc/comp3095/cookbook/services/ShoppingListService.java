package ca.gbc.comp3095.cookbook.services;

import ca.gbc.comp3095.cookbook.model.ShoppingList;

import java.util.Set;

public interface ShoppingListService extends CrudService<ShoppingList, Long> {

    // Methods to be expanded upon
    Set<ShoppingList> findAllByUserId(Long id);
}
