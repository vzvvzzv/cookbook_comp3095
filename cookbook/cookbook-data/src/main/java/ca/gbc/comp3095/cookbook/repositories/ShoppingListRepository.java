package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.ShoppingList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

    // TO DO: Query SELECT SHOPPING LIST BY USER ID
    @Query("select sl from ShoppingList sl join sl.shoppingListUser u where u.id = :id")
    Set<ShoppingList> findAllByUserId(Long id);
}
