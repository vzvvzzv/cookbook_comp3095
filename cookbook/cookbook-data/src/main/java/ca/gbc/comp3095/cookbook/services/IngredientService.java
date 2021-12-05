/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: IngredientService.java is an interface which extends the CrudService
 * and works with Ingredient & Long objects. Establishes extra crud operation methods specifically for Ingredients
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services;

import ca.gbc.comp3095.cookbook.model.Ingredient;
import ca.gbc.comp3095.cookbook.model.Recipe;

import java.util.Set;

public interface IngredientService extends CrudService<Ingredient, Long> {

    // Find ALl Ingredients by recipe
    Set<Ingredient> findAllByRecipeId(Long recipeId);

    // Save Set of Ingredients to Database
    void saveIngredientSet(Set<Ingredient> ingredientSet, Set<Recipe> recipeSet);

    //
}
