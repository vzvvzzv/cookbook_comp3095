package ca.gbc.comp3095.cookbook.services;

import ca.gbc.comp3095.cookbook.model.Meal;

import java.util.Set;

public interface MealService extends CrudService<Meal, Long>{
    Set<Meal> findMeals(Long id);
}
