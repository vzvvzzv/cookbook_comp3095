package ca.gbc.comp3095.cookbook.controllers;

import ca.gbc.comp3095.cookbook.model.Recipe;
import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.services.RecipeService;
import ca.gbc.comp3095.cookbook.services.SearchService;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/register")
@Controller
public class RegisterController {

    private final UserService userService;

    // fiddling with search for recipe
    @Autowired SearchService service;
    @Autowired RecipeService recipeService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "/register/register_form";
    }

    @PostMapping({"/process_register"})
    public String processRegister(User user){
        userService.save(user);
        return "/register/register_success";
    }
    // fiddling with search for recipe
    @RequestMapping("/")
    public String Search(Model model, @Param("keyword") String keyword) {
        List<Recipe> listRecipes = service.listAll(keyword);
        model.addAttribute("listRecipes", listRecipes);
        model.addAttribute("keyword", keyword);

        return "index";
    }

}
