/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment1
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan
 * Student Number: 101203877, 101032525, 101269485
 * Date: 2021-11-06
 * Description: MealService.java is an interface which extends the CrudService and works with Meal & Long objects.
 * Establishes extra crud operation methods specifically for Meals
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services;

import ca.gbc.comp3095.cookbook.model.Meal;

import java.util.Set;

public interface MealService extends CrudService<Meal, Long>{

    // Method to be implemented and expanded upon
    // finds all meals by user_id and returns the set of meals
    Set<Meal> findMeals(Long id);
}
