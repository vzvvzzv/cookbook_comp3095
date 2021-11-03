package ca.gbc.comp3095.cookbook.bootstrap;

import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.services.RecipeService;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final RecipeService recipeService;

    public DataLoader(UserService userService, RecipeService recipeService) {
        this.userService = userService;
        this.recipeService = recipeService;
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword("password");
        user1.setFirstname("John");
        user1.setLastname("Doe");

        userService.save(user1);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setPassword("password2");
        user2.setFirstname("Alice");
        user2.setLastname("White");

        userService.save(user2);

        Recipe recipe1 = new Recipe();
        recipe1.setRecipename("Apple Pie");

        recipeService.save(recipe1);


        // Checks if Data exists, to be deleted later
        System.out.println("Data Loaded");

        System.out.println(userService.findAll());
        System.out.println(recipeService.findAll());

    }
}
