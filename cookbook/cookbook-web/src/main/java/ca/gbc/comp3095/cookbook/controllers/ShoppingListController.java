package ca.gbc.comp3095.cookbook.controllers;

import ca.gbc.comp3095.cookbook.model.Ingredient;
import ca.gbc.comp3095.cookbook.model.ShoppingList;
import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.services.ShoppingListService;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/shoppingLists")
@Controller
public class ShoppingListController {

    private final ShoppingListService shoppingListService;
    private final UserService userService;
    private HttpSession newSession;

    public ShoppingListController(ShoppingListService shoppingListService, UserService userService) {
        this.shoppingListService = shoppingListService;
        this.userService = userService;
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


        ShoppingList tempShoppingList = shoppingListService.findById(id);

        if (tempShoppingList.getId() == -1L) {
            return "redirect:/shoppingLists/";
        } else {

            model.addAttribute("shoppingList", tempShoppingList);
            model.addAttribute("ingredients", tempShoppingList.getShopIngredientSet());

            return "/shoppinglist/details";

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
}
