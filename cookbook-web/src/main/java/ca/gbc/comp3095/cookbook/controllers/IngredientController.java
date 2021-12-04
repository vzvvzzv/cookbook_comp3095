package ca.gbc.comp3095.cookbook.controllers;

import ca.gbc.comp3095.cookbook.model.Ingredient;
import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.services.IngredientService;
import ca.gbc.comp3095.cookbook.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RequestMapping("/ingredients")
@Controller
public class IngredientController {

    private final IngredientService ingredientService;
    private final RecipeService recipeService;

    public IngredientController(IngredientService ingredientService, RecipeService recipeService) {
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
    }

    @RequestMapping("/addIngredient")
    public String addIngredient(Ingredient ingredient, HttpSession session){

        System.out.println(ingredient.getIngredientName() + " " + ingredient.getQuantity()); // Check

        Set<Ingredient> recipeIngredients = null;

        if (session.getAttribute("recipeIngredients") != null) {
            recipeIngredients = (Set) session.getAttribute("recipeIngredients");
        } else {
            recipeIngredients = new HashSet<Ingredient>();
        }
        recipeIngredients.add(ingredient);
        session.setAttribute("recipeIngredients", recipeIngredients);

        return "redirect:/recipes/createRecipe";
    }

    @RequestMapping("/removeIngredient")
    public String removeIngredient(@RequestParam String ingredientName, @RequestParam String quantity,
                                   HttpSession session){

        System.out.println(ingredientName + " " + quantity); // Check

        Ingredient ingredientRemove = new Ingredient();
        ingredientRemove.setIngredientName(ingredientName);
        ingredientRemove.setQuantity(quantity);

        Set<Ingredient> recipeIngredients = (Set) session.getAttribute("recipeIngredients");
        Iterator ingredientFind = recipeIngredients.iterator();

        while (ingredientFind.hasNext()) {
            Ingredient temp = (Ingredient) ingredientFind.next();
            if (ingredientRemove.equals(temp)) {
                recipeIngredients.remove(temp);
                break;
            }
        }

        session.setAttribute("recipeIngredients", recipeIngredients);

        return "redirect:/recipes/createRecipe";
    }

    @RequestMapping("/processIngredient")
    public String processIngredient(HttpSession session) {

        Recipe tempRecipe = (Recipe) session.getAttribute("recipeProcess");
        Set<Recipe> tempRecipeSet = new HashSet<Recipe>();
        tempRecipeSet.add(tempRecipe);
        Set<Ingredient> tempIngredients = (Set) session.getAttribute("recipeIngredients");

        Iterator ingredientIterator = tempIngredients.iterator();

        // Save Ingredients to Database
        while (ingredientIterator.hasNext()) {
            Ingredient temp = (Ingredient) ingredientIterator.next();
            System.out.println(temp.getIngredientName());
            temp.setIngredientRecipeSet(tempRecipeSet);
            ingredientService.save(temp);
        }

        // Save recipe to Database
        recipeService.save(tempRecipe);

        session.removeAttribute("recipeIngredients");
        session.removeAttribute("recipeProcess");

        return "redirect:/recipes/profile";
    }
}
