package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.ShoppingList;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {

    // TO DO: Query SELECT SHOPPING LIST BY USER ID
}
