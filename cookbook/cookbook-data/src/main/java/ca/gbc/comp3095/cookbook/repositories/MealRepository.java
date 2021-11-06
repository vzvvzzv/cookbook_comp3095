package ca.gbc.comp3095.cookbook.repositories;

import ca.gbc.comp3095.cookbook.model.Meal;
import ca.gbc.comp3095.cookbook.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.Set;

public interface MealRepository extends CrudRepository<Meal, Long> {

    @Query("Select m from Meal m join m.meal_recipe r where m.meal_user.id = :user_id AND m.meal_date between :curDate and :weekDate ")
    public Set<Meal> getMeals(Long user_id, Date curDate, Date weekDate);
}
