package ca.gbc.comp3095.cookbook.config;

import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.repositories.RecipeRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class PlanMeal {

    private final RecipeRepository recipeRepository;

    public PlanMeal(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    //https://crontab.guru/every-week
    ////“At 00:00 on Sunday.”
    @Scheduled(cron = "0 0 * * 0")
    public void PlanMealOneWeekAdvance() {


    }
    //https://crontab.guru/every-month
    //“At 00:00 on day-of-month 1.”
    @Scheduled(cron = "0 0 1 * *")
    public void PlanMealTwoWeeksAdvance() {

    }
}
