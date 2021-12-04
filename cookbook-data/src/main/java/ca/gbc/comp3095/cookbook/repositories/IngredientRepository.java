package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    // TO DO: QUERY SELECT INGREDIENTS BY RECIPE ID
    @Query("select i from Ingredient i join i.ingredientRecipeSet r where r.id = :id")
    Set<Ingredient> getSetByRecipe(Long id);

    // TO DO: QUERY SELECT INGREDIENTS BY SHOPPING LIST ID
}
