package ca.gbc.comp3095.cookbook.controllers;

import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.services.RecipeService;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/recipes")
@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private final UserService userService;
    private HttpSession newSession;

    public RecipeController(RecipeService recipeService, UserService userService) {
        this.recipeService = recipeService;
        this.userService = userService;
        this.newSession = null;
    }

    @RequestMapping({"","/", "/index.html"})
    public String index(Model model, HttpSession session) {

        // Checks if there is a user attribute in session and checks if it is in the database
        // If it is true -> newSession will be the current session
        // (Checks if newSession is null in other methods of controller)

        if ((session.getAttribute("user") != null) &&
                (userService.checkCredentials((User) session.getAttribute("user")))) {
            System.out.println(session);
            System.out.println(session.getAttribute("user"));

            model.addAttribute("recipes", recipeService.findAll());
            newSession = session;
            return "/recipes/index";
        } else {
            return "redirect:/users/login";
        }
    }

    @RequestMapping({"/profile"})
    public String profile() {

        System.out.println(newSession); // Check
        //System.out.println(newSession.getAttribute("user"));
        // Checks if newSession is established (If it is not, redirect to the login page)
        // If it is (only happens when the user has logged in, they can go to profile page)

        if (newSession == null) {
            return "redirect:/users/login";
        } else {
            return "/recipes/profile";
        }
    }

    @RequestMapping({"/logout"})
    public String logout() {
        newSession = null;
        return "redirect:/users/logout";
    }
}
