/*********************************************************************************
 * Project: Cookbook App
 * Assignment: COMP3095 Assignment1
 * Author(s): Chi Calvin Nguyen, Simon Ung, Deniz Dogan
 * Student Number: 101203877, 101032525, 101269485
 * Date: 2021-11-06
 * Description: RegisterController displays pages in the /register subdirectory.
 * RegisterController also gets information from the pages & creates users from them.
 *********************************************************************************/
package ca.gbc.comp3095.cookbook.controllers;

import ca.gbc.comp3095.cookbook.model.User;
import ca.gbc.comp3095.cookbook.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/register") // Map controller to /register path in URL
@Controller // Annotates this class as a Controller to be managed by Spring Boot
public class RegisterController {

    // UserService Dependency
    private final UserService userService;

    // Constructor Dependency Injection
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    // maps method to default page in /register path.
    // Adds user object as model.attribute and returns register_form.html
    @RequestMapping
    public String showRegister(Model model) {
        model.addAttribute("user", new User());
        return "/register/register_form";
    }

    // maps method to /register/process_register path
    // saves user with userService after form information has been filled & user properties have been assigned
    // returns register_success.html which links to login page
    @PostMapping({"/process_register"})
    public String processRegister(User user){
        userService.save(user);
        return "/register/register_success";
    }
}
