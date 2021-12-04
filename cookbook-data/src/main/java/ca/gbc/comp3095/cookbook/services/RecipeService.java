/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment1
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan
 * Student Number: 101203877, 101032525, 101269485
 * Date: 2021-11-06
 * Description: RecipeService.java is an interface which extends the CrudService and works with Recipe & Long objects.
 * Establishes extra crud operation methods specifically for Recipes
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services;

import ca.gbc.comp3095.cookbook.model.Recipe;

import java.util.Set;

public interface RecipeService extends CrudService<Recipe, Long> {

    // Methods to be implemented and expanded upon
    // finds recipes by users id and returns set of recipes (for recipes they created)
    Set<Recipe> findByUser(Long id);

    // finds recipes by users id and returns set of recipes (for users favorited recipes)
    Set<Recipe> findByFavUser(Long id);

    // finds recipes by keyword and returns set of recipes (for search using wildcards)
    Set<Recipe> findByKeyword(String key);

    // finds users favourite recipes by keyword and returns set of recipes (for search using wildcards)
    Set<Recipe> findFavByKeyword(Long id, String key);
}
