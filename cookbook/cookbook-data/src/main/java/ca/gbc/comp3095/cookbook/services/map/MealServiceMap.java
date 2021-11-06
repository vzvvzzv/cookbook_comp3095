package ca.gbc.comp3095.cookbook.services.map;

import ca.gbc.comp3095.cookbook.model.Meal;
import ca.gbc.comp3095.cookbook.repositories.MealRepository;
import ca.gbc.comp3095.cookbook.services.MealService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Service
public class MealServiceMap extends AbstractMapService<Meal, Long> implements MealService {

    private final MealRepository mealRepository;

    public MealServiceMap(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Set<Meal> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Meal meal) {
        super.delete(meal);
    }

    @Override
    public Meal findById(Long aLong) {
        return null;
    }

    @Override
    public Meal save(Meal meal) {
        return super.save(mealRepository, meal);
    }

    @Override
    public Set<Meal> findMeals(Long id) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Date curDate = cal.getTime();
        System.out.println(curDate.toString());
        cal.add(Calendar.DATE, 7);
        Date weekDate = cal.getTime();
        System.out.println(weekDate.toString());

        Set<Meal> tempSet = mealRepository.getMeals(id, curDate, weekDate);
        System.out.println("This is the meal" + tempSet);

        return tempSet;
    }
}
