/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: RecipeServiceMap.java is a class which extends the AbstractMapService and works with
 * Recipe & Long objects. Overrides methods & implements recipe specific logic
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.repositories.RecipeRepository;
import ca.gbc.comp3095.cookbook.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service // Annotates this class as a Service to be managed by Spring Boot
public class RecipeServiceMap extends AbstractMapService<Recipe, Long> implements RecipeService {

    // RecipeRepository dependency
    private final RecipeRepository recipeRepository;

    // Constructor Dependency Injection
    public RecipeServiceMap(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    // Possibly change findAll(), deleteById, and delete later
    @Override
    public Set<Recipe> findAll() {
        return super.findAll(recipeRepository);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(recipeRepository, id);
    }

    @Override
    public void delete(Recipe recipe) {
        super.delete(recipeRepository, recipe);
    }

    // Saves recipe to database by calling super.save and passing recipeRepository & recipe
    @Override
    public Recipe save(Recipe recipe) {
        return super.save(recipeRepository, recipe);
    }

    // Finds recipe from database by calling super.findById and passing recipeRepository & id
    // If no entry is returned (null) pass a new Recipe object with an id of -1L
    @Override
    public Recipe findById(Long id) {
        Recipe toReturn =  super.findById(recipeRepository, id);

        if (toReturn == null) {
            toReturn = new Recipe();
            toReturn.setId(-1L);
        }
        return toReturn;
    }

    // Overrides RecipeService method
    // Returns set of recipes from database by the user id
    @Override
    public Set<Recipe> findByUser(Long id) {
        return recipeRepository.getSetByUser(id);
    }

    // Overrides RecipeService method
    // Returns set of recipes from database by the user id (for favorite recipes)
    @Override
    public Set<Recipe> findByFavUser(Long id) {
        return recipeRepository.getUserFav(id);
    }

    // Overrides RecipeService method
    // Returns set of recipes from database by keyword (wildcard search)
    @Override
    public Set<Recipe> findByKeyword(String key) {
        Set<Recipe> tempSet = recipeRepository.getSetByKeyword(key);
        if (tempSet == null) {
            tempSet = Collections.emptySet();
        }
        return tempSet;
    }

    @Override
    public Set<Recipe> findFavByKeyword(Long id, String key) {
        Set<Recipe> tempSet = recipeRepository.getSetFavByKeyword(id, key);
        if (tempSet == null) {
            tempSet = Collections.emptySet();
        }
        return tempSet;
    }
}
