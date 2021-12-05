/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: MealServiceMap.java is a class which extends the AbstractMapService and works with Meal & Long objects.
 * Overrides methods & implements meal specific logic
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.Meal;
import ca.gbc.comp3095.cookbook.repositories.MealRepository;
import ca.gbc.comp3095.cookbook.services.MealService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Service // Annotates this class as a Service to be managed by Spring Boot
public class MealServiceMap extends AbstractMapService<Meal, Long> implements MealService {

    // MealRepository dependency
    private final MealRepository mealRepository;

    // Constructor Dependency Injection
    public MealServiceMap(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    // Possibly change findAll(), deleteById, delete, and findById later
    @Override
    public Set<Meal> findAll() {
        return super.findAll(mealRepository);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(mealRepository, id);
    }

    @Override
    public void delete(Meal meal) {
        super.delete(mealRepository, meal);
    }

    @Override
    public Meal findById(Long aLong) {
        return null;
    }

    // Saves meal to database by calling super.save and passing mealRepository & meal
    @Override
    public Meal save(Meal meal) {
        return super.save(mealRepository, meal);
    }

    // Returns set of meals by calling mealRepository.getMeals, passes user id, two dates (for range)
    @Override
    public Set<Meal> findMeals(Long id) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Date curDate = cal.getTime();
        cal.add(Calendar.DATE, 7);
        Date weekDate = cal.getTime();

        Set<Meal> tempSet = mealRepository.getMeals(id, curDate, weekDate);

        return tempSet;
    }
}
