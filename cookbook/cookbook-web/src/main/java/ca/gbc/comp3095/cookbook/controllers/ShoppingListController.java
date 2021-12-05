/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment2
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan, Armen Levon Armen
 * Student Number: 101203877, 101032525, 101269485, 101281931
 * Date: 2021-12-5
 * Description: ShoppingListController displays pages in the /shoppinglist subdirectory.
 * ShoppingListController manages the creation, deletion, displaying of shoppinglists
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.controllers;

import ca.gbc.comp3095.cookbook.model.Ingredient;
import ca.gbc.comp3095.cookbook.model.ShoppingList;
import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.services.IngredientService;
import ca.gbc.comp3095.cookbook.services.ShoppingListService;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RequestMapping("/shoppingLists")
@Controller
public class ShoppingListController {

    private final ShoppingListService shoppingListService;
    private final UserService userService;
    private final IngredientService ingredientService;
    private HttpSession newSession;

    public ShoppingListController(ShoppingListService shoppingListService, UserService userService,
                                  IngredientService ingredientService) {
        this.shoppingListService = shoppingListService;
        this.userService = userService;
        this.ingredientService = ingredientService;
        this.newSession = null;
    }

    private boolean newSessionCheck(){
        return newSession == null;
    }

    @RequestMapping({"/", "", "/index"})
    public String index(Model model, HttpSession session) {

        if ((session.getAttribute("user") != null) &&
                (userService.checkCredentials((User) session.getAttribute("user")))) {

            newSession = session;

            User tempUser = userService.findByUsername(((User) newSession.getAttribute("user")).getUsername());
            Set<ShoppingList> usersShoppingLists = shoppingListService.findAllByUserId(tempUser.getId());

            model.addAttribute("shoppingLists", usersShoppingLists);

            return "/shoppinglist/index";
        } else {
            return "redirect:/users/login";
        }
    }

    @RequestMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {

        if (newSessionCheck()) {
            return "redirect:/users/login";
        } else {

            ShoppingList tempShoppingList = shoppingListService.findById(id);

            if (tempShoppingList.getId() == -1L) {
                return "redirect:/shoppingLists/";
            } else {

                model.addAttribute("shoppingList", tempShoppingList);
                model.addAttribute("ingredients", tempShoppingList.getShopIngredientSet());

                return "/shoppinglist/details";

            }
        }
    }

    @RequestMapping("/createShoppingList")
    public String createShoppingList(Model model) {

        if (newSessionCheck()) {
            return "redirect:/users/login";
        } else {

            model.addAttribute("shoppingList", new ShoppingList());
            return "/shoppinglist/create-shoppinglist";
        }
    }

    @RequestMapping("/processShoppingList")
    public String processShoppingList(ShoppingList shoppingList) {

        User tempUser = userService.findByUsername(((User) newSession.getAttribute("user")).getUsername());
        Set<Ingredient> tempIngredientSet = new HashSet<>();

        shoppingList.setShoppingListUser(tempUser);
        shoppingList.setShopIngredientSet(tempIngredientSet);

        shoppingListService.save(shoppingList);

        return "redirect:/shoppingLists/";
    }

    @RequestMapping("/deleteIngredientFromList")
    public String deleteIngredientFromList(@RequestParam Long shoppingListId, @RequestParam Long ingredientId) {

        ShoppingList tempShoppingList = shoppingListService.findById(shoppingListId);
        Set<Ingredient> tempIngredientSet = tempShoppingList.getShopIngredientSet();

        Iterator findIngredient = tempIngredientSet.iterator();

        while (findIngredient.hasNext()) {
            Ingredient temp = (Ingredient) findIngredient.next();
            if (temp.getId() == ingredientId) {
                tempIngredientSet.remove(temp);
                break;
            }
        }

        tempShoppingList.setShopIngredientSet(tempIngredientSet);
        shoppingListService.save(tempShoppingList);

        return "redirect:/shoppingLists/details/" + shoppingListId;
    }

    @RequestMapping("/addIngredientToList")
    public String addIngredientToList(@RequestParam Long recipeId,
                                      @RequestParam Long ingredientId, Model model, HttpSession session) {

        if ((session.getAttribute("user") != null) &&
                (userService.checkCredentials((User) session.getAttribute("user")))) {

            newSession = session;

            User tempUser = userService.findByUsername(((User) newSession.getAttribute("user")).getUsername());
            Set<ShoppingList> usersShoppingLists = shoppingListService.findAllByUserId(tempUser.getId());

            Ingredient ingredient = ingredientService.findById(ingredientId);

            model.addAttribute("recipeId", recipeId);
            model.addAttribute("ingredient", ingredient);
            model.addAttribute("userShoppingLists", usersShoppingLists);

            return "/shoppinglist/add-ingredient";
        } else {
            return "redirect:/users/login";
        }
    }

    @RequestMapping("/processAddToList")
    public String processAddToList(@RequestParam Long recipeId,
                                   @RequestParam Long ingredientId, @RequestParam Long shoppingListId) {


        ShoppingList tempShoppingList = shoppingListService.findById(shoppingListId);
        Set<Ingredient> tempIngredientSet = tempShoppingList.getShopIngredientSet();

        Ingredient ingredient = ingredientService.findById(ingredientId);

        tempIngredientSet.add(ingredient);
        tempShoppingList.setShopIngredientSet(tempIngredientSet);

        shoppingListService.save(tempShoppingList);


        return "redirect:/recipes/details?id=" + recipeId;
    }

    @RequestMapping("/exportShoppingList")
    public String exportShoppingList() {
        return null;
    }
}
