package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    // fiddling with search for recipe
    @Query("SELECT r FROM Recipe r WHERE r.recipename LIKE %?1%")
    public List<Recipe> search(String keyword);
}
