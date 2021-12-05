/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: MealRepository.java extends the CrudRepository allows for CRUD operations to the h2-database.
 * MealRepository specifically returns Meal objects and possesses special queries
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.Meal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Set;

public interface MealRepository extends CrudRepository<Meal, Long> {

    // Specially defined select query using @Query
    // Returns set of meals for a specific user within a date range of today and a week from today
    @Query("Select m from Meal m join m.meal_recipe r where m.meal_user.id = :user_id AND m.meal_date between :curDate and :weekDate ")
    Set<Meal> getMeals(Long user_id, Date curDate, Date weekDate);
}
