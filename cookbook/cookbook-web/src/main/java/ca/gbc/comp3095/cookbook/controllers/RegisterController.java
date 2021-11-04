package ca.gbc.comp3095.cookbook.controllers;

import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/register")
@Controller
public class RegisterController {

    private final UserService userService;

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
}
