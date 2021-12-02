package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    // TO DO: QUERY SELECT INGREDIENTS BY RECIPE ID

    // TO DO: QUERY SELECT INGREDIENTS BY SHOPPING LIST ID
}
