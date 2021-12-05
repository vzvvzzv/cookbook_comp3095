/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: IngredientController displays pages in the /ingredients subdirectory.
 * IngredientController manages the addition, edit and deletion of ingredients into recipes
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.controllers;

import ca.gbc.comp3095.cookbook.model.Ingredient;
import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.services.IngredientService;
import ca.gbc.comp3095.cookbook.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/addUpdateIngredient")
    public String addUpdateIngredient(@RequestParam Long recipeId, Ingredient ingredient, HttpSession session){

        System.out.println(ingredient.getIngredientName() + " " + ingredient.getQuantity()); // Check

        Set<Ingredient> recipeIngredients = ingredientService.findAllByRecipeId(recipeId);
        Recipe tempRecipe = recipeService.findById(recipeId);

        recipeIngredients.add(ingredient);
        tempRecipe.setRecipeIngredientSet(recipeIngredients);
        ingredientService.save(ingredient);
        recipeService.save(tempRecipe);

        return "redirect:/recipes/updateRecipe/" + recipeId;
    }

    @RequestMapping("/deleteIngredient")
    public String deleteIngredient(@RequestParam Long recipeId, @RequestParam String ingredientName,
                                   @RequestParam String quantity, HttpSession session){

        Ingredient ingredientRemove = new Ingredient();
        ingredientRemove.setIngredientName(ingredientName);
        ingredientRemove.setQuantity(quantity);

        Set<Ingredient> recipeIngredients = ingredientService.findAllByRecipeId(recipeId);
        Iterator ingredientFind = recipeIngredients.iterator();
        Recipe tempRecipe = recipeService.findById(recipeId);

        while (ingredientFind.hasNext()) {
            Ingredient temp = (Ingredient) ingredientFind.next();
            if (ingredientRemove.equals(temp)) {

                recipeIngredients.remove(temp); // Remove ingredient from set
                tempRecipe.setRecipeIngredientSet(recipeIngredients); // set updated set to recipe
                recipeService.save(tempRecipe); // save recipe to database
                ingredientService.deleteById(temp.getId()); // delete ingredient from database

                break;
            }
        }

        return "redirect:/recipes/updateRecipe/" + recipeId;
    }

    @RequestMapping("/editIngredient")
    public String editIngredient(@RequestParam Long recipeId, @RequestParam Long ingredientId,
                                 Model model, HttpSession session) {

        System.out.println(ingredientId);
        Ingredient tempIngredient = ingredientService.findById(ingredientId);

        session.setAttribute("recipeId", recipeId);
        model.addAttribute("currentIngredient", tempIngredient);

        return "/ingredients/edit-ingredient";
    }

    @RequestMapping("/processEditIngredient")
    public String processEditIngredient(Ingredient ingredient, HttpSession session){

        ingredientService.save(ingredient);
        Long recipeId = (Long) session.getAttribute("recipeId");
        session.removeAttribute("recipeId");

        return "redirect:/recipes/updateRecipe/" + recipeId;
    }
}
