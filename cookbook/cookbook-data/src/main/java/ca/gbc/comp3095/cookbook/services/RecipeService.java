package ca.gbc.comp3095.cookbook.services;

import ca.gbc.comp3095.cookbook.model.Recipe;

import java.util.List;
import java.util.Set;

public interface RecipeService extends CrudService<Recipe, Long> {
    Recipe findById (Long type);
    Recipe findByTitle(String title);
    List<Recipe> findByUser(Long id);
    Set<Recipe> findByFavUser(Long id);
}
